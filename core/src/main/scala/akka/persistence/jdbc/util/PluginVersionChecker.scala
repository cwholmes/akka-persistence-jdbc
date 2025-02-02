/*
 * Copyright (C) 2014 - 2019 Dennis Vriend <https://github.com/dnvriend>
 * Copyright (C) 2019 - 2022 Lightbend Inc. <https://www.lightbend.com>
 */

package akka.persistence.jdbc.util

import akka.annotation.InternalApi

@InternalApi
private[jdbc] object PluginVersionChecker {
  def check(): Unit =
    try {
      Class.forName("akka.persistence.jdbc.util.DefaultSlickDatabaseProvider")
      throw new RuntimeException(
        "Old version of Akka Persistence JDBC found on the classpath. Remove `com.github.dnvriend:akka-persistence-jdbc` from the classpath..")
    } catch {
      case _: ClassNotFoundException =>
      // All good! That's intentional.
      // It's good if we don't have akka.persistence.jdbc.util.DefaultSlickDatabaseProvider around
    }
}
