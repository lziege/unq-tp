package ar.edu.unq.desapp.grupog.backenddesappapi.test.service

import ar.edu.unq.desapp.grupog.backenddesappapi.service.UserService
import ar.edu.unq.desapp.grupog.backenddesappapi.test.utils.UserBuilder
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.RuntimeException

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTestCase {
    @Autowired private lateinit var userService: UserService
    private lateinit var builder: UserBuilder

    @BeforeEach fun setup() { builder = UserBuilder() }

    @Test
    fun testCreate_CreateAnUserSuccessfully() {
        val createdUser = userService.create(builder.build())
        Assertions.assertNotNull(createdUser.id)
    }

    @Test
    fun testCreate_ShouldThrowAnExceptionWhenEmailIsUsed() {
        userService.create(builder.build())
        assertThrows<RuntimeException> {
            userService.create(
                builder.withName("Franco")
                    .withLastname("Garcino")
                    .build()
            )
        }
    }

    @Test
    fun testCreate_ShouldThrowAnExceptionWhenCVUIsUsed() {
        userService.create(builder.build())
        assertThrows<RuntimeException> {
            userService.create(
                builder.withName("Franco")
                    .withLastname("Garcino")
                    .withEmail("fgarcino@gmail.com")
                    .build()
            )
        }
    }

    @Test
    fun testCreate_ShouldThrowAnExceptionWhenWalletIsUsed() {
        userService.create(builder.build())
        assertThrows<RuntimeException> {
            userService.create(
                builder.withName("Franco")
                    .withLastname("Garcino")
                    .withEmail("fgarcino@gmail.com")
                    .withCVU("2121212121212121212121")
                    .build()
            )
        }
    }

    @Test
    fun testUpdate_UpdateSuccessfully() {
        val anUser = userService.create(builder.build())
        anUser.apply { email = "backup-mail@gmail.com" }
        userService.update(anUser)
        val updatedUser = userService.read(anUser.id!!)

        Assertions.assertEquals(anUser.firstName, updatedUser.firstName)
        Assertions.assertEquals(anUser.lastName, updatedUser.lastName)
        Assertions.assertEquals(anUser.address, updatedUser.address)
        Assertions.assertEquals(anUser.cvu, updatedUser.cvu)
        Assertions.assertEquals(anUser.wallet, updatedUser.wallet)
        Assertions.assertEquals(anUser.password, updatedUser.password)
        Assertions.assertEquals(anUser.email, updatedUser.email)
    }

    @Test
    fun testUpdate_ShouldThrowAnExceptionWhenTheUserDoesNotExists() {
        assertThrows<RuntimeException> { userService.update(builder.build()) }
    }
    @Test
    fun testRead_RecoversSimilarObjects() {
        val anUser = userService.create(builder.build())
        val recoveryUser = userService.read(anUser.id!!)

        Assertions.assertEquals(anUser.firstName, recoveryUser.firstName)
        Assertions.assertEquals(anUser.lastName, recoveryUser.lastName)
        Assertions.assertEquals(anUser.address, recoveryUser.address)
        Assertions.assertEquals(anUser.cvu, recoveryUser.cvu)
        Assertions.assertEquals(anUser.wallet, recoveryUser.wallet)
        Assertions.assertEquals(anUser.password, recoveryUser.password)
        Assertions.assertEquals(anUser.email, recoveryUser.email)

        Assertions.assertTrue(anUser !== recoveryUser)
    }

    @Test
    fun testRead_ShouldThrowAnExceptionWhenTheIdDoesNotMatchWithAnyUser() {
        assertThrows<RuntimeException> { userService.read(1) }
    }

    @Test
    fun testRead_ShouldThrowAnExceptionWhenTheIdIsInvalid() {
        assertThrows<RuntimeException> { userService.read(-1) }
    }

    @Test
    fun testReadAll_RecoversAllTheUsersInTheDatabase() {
        val aDefaultUser = userService.create(builder.build())
        val anotherUser = userService.create(
            builder.withEmail("notDefault@hotmail.com")
                .withWallet("12346578")
                .withCVU("0000010000000000100000")
                .build()
        )

        val users = userService.readAll()
        Assertions.assertEquals(2, users.size)
        Assertions.assertTrue(users.any { u -> u.wallet == aDefaultUser.wallet })
        Assertions.assertTrue(users.any { u -> u.wallet == anotherUser.wallet })
    }

    @Test
    fun testReadAll_ShouldReturnsAnEmptyListIfDatabaseHaveNoUsers() {
        Assertions.assertTrue(userService.readAll().isEmpty())
    }

    @Test
    fun testDelete_DeleteTheUserFromDatabase() {
        val anUser = userService.create(builder.build())
        assertDoesNotThrow { userService.read(anUser.id!!) }
        userService.delete(anUser.id!!)
        assertThrows<RuntimeException> { userService.read(anUser.id!!) }
    }

    @Test
    fun testDeleteAll_DeletesAllTheUsersInTheDatabase() {
        userService.create(builder.build())
        Assertions.assertTrue(userService.readAll().isNotEmpty())
        userService.deleteAll()
        Assertions.assertTrue(userService.readAll().isEmpty())
    }

    @AfterEach fun teardown() { userService.deleteAll() }
}