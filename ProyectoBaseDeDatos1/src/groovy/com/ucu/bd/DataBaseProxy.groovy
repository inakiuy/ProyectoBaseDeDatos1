package com.ucu.bd


import java.sql.DriverManager

import groovy.sql.Sql

/**
 *
 * @author gaspar.medina
 *
 * @see http://docs.groovy-lang.org/latest/html/api/groovy/sql/Sql.html
 *
 */
class DataBaseProxy {

	/**
	 * Connect with database instance
	 *
	 * @param url
	 * @param userName
	 * @param userPassword
	 * @param driverClass
	 *
	 * @return sql instance for do queries
	 */
	Sql connect () {

		Sql sql = Sql.newInstance('jdbc:postgresql://10.8.0.1:5432/bd-ucu', 'gaspar', 'g4sp4rvpn', 'org.postgresql.Driver')

		return sql
	}

	/**
	 * Disconnect database instance
	 *
	 * @param sql
	 */
	void disconnect(sql) {
		sql.close()
	}

}
