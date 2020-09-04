package com.makimenko.fs.domain;

import com.makimenko.fs.domain.book.Author;
import com.makimenko.fs.domain.book.BookGenre;
import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void serializeDeserialize() throws Exception {

        BookGenre detective = new BookGenre();
        detective.setId("D");
        detective.setName("Detective");

        Author author = new Author();
        author.setId(UUID.randomUUID());
        author.setName("Nick");
        author.setLicenseId("LIC1");
        author.setBirthDate(LocalDate.now());

        byte[] bytes = serialize(author);
        Author result = (Author) deserialize(bytes);
        assertEquals(author.toString(), result.toString());

        author.setLicenseId("L2");
        assertNotEquals(author.toString(), result.toString());
    }

    private byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(object);
            out.flush();
            byte[] yourBytes = bos.toByteArray();
            return yourBytes;

        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }

    private Object deserialize(byte[] byteObject) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(byteObject);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            Object o = in.readObject();
            return o;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }
}

