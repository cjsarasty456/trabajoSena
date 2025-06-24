import React, { useEffect, useState } from "react";
import {
  View,
  Text,
  TouchableOpacity,
  StyleSheet,
  FlatList,
  useWindowDimensions,
} from "react-native";
import { useNavigation } from "@react-navigation/native";

import { BookStackParamsList } from "../navigations/types";
import { NativeStackNavigationProp } from "@react-navigation/native-stack";
import { getAllBook } from "../api/booksApi";
import { IBook } from "../api/types/IBook";
import BookCard from "../components/BookCard";

type BookScreenNavigationProp = NativeStackNavigationProp<
  BookStackParamsList,
  "ListBook"
>;

const ListBookScreen = () => {
  const navigation = useNavigation<BookScreenNavigationProp>();
  const [books, setBooks] = useState<IBook[]>([]);
  useEffect(() => {
    const fetchData = async () => {
      const response = await getAllBook();
      setBooks(response);
    };

    fetchData();
  }, []);
  const { width } = useWindowDimensions();

  const numColumns = width < 500 ? 1 : width < 800 ? 2 : 3; // 2 columnas si el ancho es mayor a 600, 1 si no

  return (
    <View>
      <Text style={styles.title}>List Book</Text>

      <TouchableOpacity
        style={styles.touch}
        onPress={() => navigation.navigate("AddBook")}
      >
        <Text>Add book</Text>
      </TouchableOpacity>
      <FlatList
        data={books}
        keyExtractor={(item) => item.id_book.toString()}
        renderItem={({ item }) => <BookCard book={item} />}
        numColumns={numColumns}
        key={numColumns}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  title: {
    fontSize: 50,
    textAlign: "center",
  },
  touch: {
    margin: 5,
    backgroundColor: "#1e90ff", // azul tipo botón
    paddingVertical: 12,
    paddingHorizontal: 24,
    borderRadius: 10,
    alignItems: "center",
    justifyContent: "center",
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.3,
    shadowRadius: 3,
    elevation: 5, // sombra en Android
    width: 150,
  },
});

export default ListBookScreen;
