import React, { useState } from "react";

import { View, Button, StyleSheet } from "react-native";
import { createBook } from "../api/booksApi";
import { IBook } from "../api/types/IBook";
import BookForm from "../components/BookForm";

export default function AddBookScreen() {
  const [form, setForm] = useState<IBook>({
    id_book: "",
    title: "",
    author: "",
    publisher: "",
    description: "",
    isbn: "",
    stock: "",
    status: "",
    state_book: "",
  });
  const handleChange = (name: string, value: string) => {
    setForm({ ...form, [name]: value });
  };
  const registerBook = async () => {
    const register = await createBook(form);
  };

  return (
    <View>
      <BookForm form={form} handleChange={handleChange} />
      <Button title="Guardar" onPress={registerBook} />
    </View>
  );
}

const styles = StyleSheet.create({
  title: {
    fontSize: 50,
    textAlign: "center",
  },
});
