// components/BookCard.tsx
import React from "react";
import { View, Text, StyleSheet, TouchableOpacity } from "react-native";
import { IBook } from "../api/types/IBook";
import { useNavigation } from "@react-navigation/native";
import { NativeStackNavigationProp } from "@react-navigation/native-stack";
import { BookStackParamsList } from "../navigations/types";
import { deleteBook } from "../api/booksApi";

interface Props {
  data: IBook;
}

const BookCard: React.FC<Props> = ({ data }) => {
  const navigation =
    useNavigation<NativeStackNavigationProp<BookStackParamsList>>();

  const handleEdit = () => {
    navigation.navigate("UpdateBook", { bookId: data.id_book.toString() });
  };

  const handleDelete = async () => {
    const registro = await deleteBook(data.id_book);
  };

  return (
    <View style={styles.card}>
      <Text style={styles.title}>{data.title}</Text>
      <Text style={styles.text}>Autor: {data.author}</Text>
      <Text style={styles.text}>Editorial: {data.publisher}</Text>

      <View style={styles.buttonContainer}>
        <TouchableOpacity style={styles.buttonEdit} onPress={handleEdit}>
          <Text style={styles.buttonText}>Editar</Text>
        </TouchableOpacity>

        <TouchableOpacity style={styles.buttonDelete} onPress={handleDelete}>
          <Text style={styles.buttonText}>Eliminar</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  card: {
    backgroundColor: "#f8f8f8",
    padding: 16,
    margin: 8,
    borderRadius: 10,
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.2,
    shadowRadius: 4,
    elevation: 4,
  },
  title: {
    fontSize: 18,
    fontWeight: "bold",
    marginBottom: 6,
  },
  text: {
    fontSize: 14,
    color: "#333",
  },
  buttonContainer: {
    flexDirection: "row",
    marginTop: 12,
    justifyContent: "space-between",
  },
  buttonEdit: {
    backgroundColor: "#1e90ff",
    paddingVertical: 8,
    paddingHorizontal: 16,
    borderRadius: 8,
  },
  buttonDelete: {
    backgroundColor: "#ff4d4d",
    paddingVertical: 8,
    paddingHorizontal: 16,
    borderRadius: 8,
  },
  buttonText: {
    color: "#fff",
    fontWeight: "bold",
  },
});

export default BookCard;
