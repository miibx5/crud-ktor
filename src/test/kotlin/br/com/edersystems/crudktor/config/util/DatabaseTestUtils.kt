/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:46:36
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.config.util

import java.sql.DriverManager
import java.sql.ResultSet


class DatabaseTestUtils(
    private val jdbcUrl: String,
    private val password: String,
    private val username: String
) {

    fun cleanAllTables() {
        println("-> Cleaning database")

        val connection = getConnection()
        val sql = "CREATE OR REPLACE FUNCTION truncate_tables(username IN VARCHAR) RETURNS void AS \$\$\n" +
                "DECLARE\n" +
                "    statements CURSOR FOR\n" +
                "        SELECT tablename FROM pg_tables\n" +
                "        WHERE tableowner = username AND schemaname = 'public';\n" +
                "BEGIN\n" +
                "    FOR stmt IN statements LOOP\n" +
                "        EXECUTE 'TRUNCATE TABLE ' || quote_ident(stmt.tablename) || ' CASCADE;';\n" +
                "    END LOOP;\n" +
                "END;\n" +
                "\$\$ LANGUAGE plpgsql;" +
                "SELECT truncate_tables('postgres');"

        connection.prepareCall(sql).execute()
        connection.close()
    }

    private fun getConnection() = DriverManager.getConnection(jdbcUrl, username, password)

    fun executePrepareCall(sql: String): ResultSet {
        val connection = getConnection()
        connection.use { return it.prepareCall(sql).executeQuery() }
    }
}
