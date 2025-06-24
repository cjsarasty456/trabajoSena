// components/BookList.tsx
import React, { useEffect, useState, useCallback } from "react";
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  RefreshControl,
} from "react-native";
import { getAllBook } from "../api/booksApi";
import { IBook } from "../api/types/IBook";
import BookCard from "./../components/BookCard";

const BookList: React.FC = () => {
  const [books, setBooks] = useState<IBook[]>([]);
  const [refreshing, setRefreshing] = useState(false);

  const fetchBooks = async () => {
    try {
      const data = await getAllBook();
      setBooks(data);
    } catch (error) {
      console.error("Error al obtener libros:", error);
    }
  };

  useEffect(() => {
    fetchBooks();
  }, []);

  const onRefresh = useCallback(async () => {
    setRefreshing(true);
    await fetchBooks();
    setRefreshing(false);
  }, []);

  return (
    <ScrollView
      contentContainerStyle={styles.container}
      refreshControl={
        <RefreshControl refreshing={refreshing} onRefresh={onRefresh} />
      }
    >
      {books.length === 0 ? (
        <View style={styles.center}>
          <Text>No hay libros disponibles.</Text>
        </View>
      ) : (
        books.map((book) => (
          <BookCard key={book.id_book} data={book} />
        ))
      )}
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    paddingVertical: 10,
  },
  center: {
    alignItems: "center",
    justifyContent: "center",
    marginTop: 20,
  },
});

export default BookList;
