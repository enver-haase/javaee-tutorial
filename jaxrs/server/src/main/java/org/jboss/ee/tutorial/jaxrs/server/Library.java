/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.ee.tutorial.jaxrs.server;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/library")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class Library {

    private Map<String, Book> books = new LinkedHashMap<String, Book>();

    public Library() {
        Book[] bookarr = new Book[] { new Book("1234", "Harry Potter") };
        for (Book book : bookarr) {
            books.put(book.getIsbn(), book);
        }
    }

    @GET
    @Path("/books")
    public Collection<Book> getBooks() {
        return books.values();
    }

    @GET
    @Path("/book/{isbn}")
    public Book getBook(@PathParam("isbn") String id) {
        Book result = books.get(id);
        return result;

    }
}