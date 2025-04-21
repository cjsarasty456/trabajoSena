import React, { useState } from "react";

import {
  View,
  Text,
  TextInput,
  Button,
  ScrollView,
  StyleSheet,
  Alert,
} from "react-native";
import { book } from "../api/types/book";

export default function AddBookScreen() {
  const [form, setForm] = useState({
    title: "",
    author: "",
    publisher: "",
    description: "",
    isbn: "",
    stock: "",
    status: "",
    state_book: "",
  });
  const preparedForm = {
    ...form,
    isbn: Number(form.isbn),
    stock: Number(form.stock),
    status: Number(form.status),
    state_book: Number(form.state_book),
  };
  const handleChange = (name: string, value: string) => {
    setForm({ ...form, [name]: value });
  };
  const createBook = async (): Promise<void> => {
    const response = await fetch("http://192.168.1.9:8080/api/v1/book/", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(preparedForm),
    });

    if (!response.ok) throw new Error("Error al crear el libro");
    let data = await response.json();
    console.log(data);
    return data;
  };
  return (
    <View>
      <Text style={styles.title}>Add Book</Text>
      <ScrollView contentContainerStyle={styles.container}>
        <TextInput
          style={styles.input}
          placeholder="Título"
          value={form.title}
          onChangeText={(text) => handleChange("title", text)}
        />
        <TextInput
          style={styles.input}
          placeholder="Autor"
          value={form.author}
          onChangeText={(text) => handleChange("author", text)}
        />
        <TextInput
          style={styles.input}
          placeholder="Editorial"
          value={form.publisher}
          onChangeText={(text) => handleChange("publisher", text)}
        />
        <TextInput
          style={styles.input}
          placeholder="Descripción"
          value={form.description}
          onChangeText={(text) => handleChange("description", text)}
          multiline
          numberOfLines={3}
        />
        <TextInput
          style={styles.input}
          placeholder="ISBN"
          value={form.isbn}
          onChangeText={(text) => handleChange("isbn", text)}
          keyboardType="numeric"
        />
        <TextInput
          style={styles.input}
          placeholder="Stock"
          value={form.stock}
          onChangeText={(text) => handleChange("stock", text)}
          keyboardType="numeric"
        />
        <TextInput
          style={styles.input}
          placeholder="Status"
          value={form.status}
          onChangeText={(text) => handleChange("status", text)}
          keyboardType="numeric"
        />
        <TextInput
          style={styles.input}
          placeholder="Estado del libro"
          value={form.state_book}
          // onChangeText={(text) => handleChange("state_book", text)}
          keyboardType="numeric"
        />

        <Button title="Guardar" onPress={createBook} />
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  title: {
    fontSize: 50,
    textAlign: "center",
  },
  container: {
    padding: 20,
  },
  input: {
    borderWidth: 1,
    borderColor: "#aaa",
    padding: 12,
    borderRadius: 8,
    marginBottom: 16,
  },
});
