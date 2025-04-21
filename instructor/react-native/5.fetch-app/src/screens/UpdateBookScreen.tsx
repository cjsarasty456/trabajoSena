import React, { useState, useEffect } from "react";

import { View, Button, StyleSheet } from "react-native";
import { getByIdBook, updateBook } from "../api/booksApi";
import { IBook } from "../api/types/IBook";
import BookForm from "../components/BookForm";
import { BookStackParamsList } from "../navigations/types";
import { RouteProp, useRoute } from "@react-navigation/native";

type UpdateRouteProp = RouteProp<BookStackParamsList, "UpdateBook">;

export default function UpdateBookScreen() {
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
  const route = useRoute<UpdateRouteProp>();
  const { bookId } = route.params;
  useEffect(() => {
    const fetchData = async () => {
      const response = await getByIdBook(Number(bookId));
      setForm(response);
    };

    fetchData();
  }, []);
  const handleChange = (name: string, value: string) => {
    setForm({ ...form, [name]: value });
  };
  const requestUpdateBook = async () => {
    const register = await updateBook(Number(bookId), form);
  };

  return (
    <View>
      <BookForm form={form} handleChange={handleChange} />
      <Button title="Guardar" onPress={requestUpdateBook} />
    </View>
  );
}

const styles = StyleSheet.create({
  title: {
    fontSize: 50,
    textAlign: "center",
  },
});
