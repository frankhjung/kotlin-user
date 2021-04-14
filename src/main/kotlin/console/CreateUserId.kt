package console

import kotlin.system.exitProcess
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required

private val logger = mu.KotlinLogging.logger {}

/**
   * Create a userid from a username. This writes the username to a database and returns the created
   * user id.
   * @param args command line arguments
   */
  fun main(args: Array<String>) {
    val parser = ArgParser("CreateUser")
    val username by parser
        .option(ArgType.String, shortName = "u", description = "Username")
        .required()

    parser.parse(args)
    logger.info("Creating user $username ...")

    //  val sessionFactory: SessionFactory = Configuration().configure().buildSessionFactory()
    //  sessionFactory.use { sf ->
    //    persist(sf, username)
    //    load(sf)
    //  }

    exitProcess(0)
  }

  // fun persist(sessionFactory: SessionFactory, username: String) {
  //  val user = User(0, username)
  //  sessionFactory.openSession().apply {
  //    this.beginTransaction()
  //    this.persist(user)
  //    transaction.commit()
  //    println("Created user ${user.name} with id ${user.id}")
  //  }
  // }

  // fun load(sessionFactory: SessionFactory) {
  //  val session = sessionFactory.openSession()
  //  val users: List<User> = session.createQuery("FROM user").list() as List<User>
  //  users.forEach(Consumer { u: User -> println("Found user ${u.name} with id ${u.id}%n") })
  //  session.close()
  // }