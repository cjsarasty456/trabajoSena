import React from "react";
import { View, Text, TouchableOpacity, StyleSheet } from "react-native";
import { useNavigation } from "@react-navigation/native";

import { BookStackParamsList } from "../navigations/types";
import { NativeStackNavigationProp } from "@react-navigation/native-stack";

type BookScreenNavigationProp = NativeStackNavigationProp<
  BookStackParamsList,
  "ListBook"
>;

const ListBookScreen = () => {
  const navigation = useNavigation<BookScreenNavigationProp>();
  return (
    <View>
      <Text style={styles.title}>List Book</Text>
      <TouchableOpacity
        style={styles.touch}
        onPress={() => navigation.navigate("AddBook")}
      >
        <Text>Add book</Text>
      </TouchableOpacity>
      <TouchableOpacity
        style={styles.touch}
        onPress={() =>
          navigation.navigate("DetailBook", {
            bookId: "123",
          })
        }
      >
        <Text>Details book</Text>
      </TouchableOpacity>
      <TouchableOpacity
        style={styles.touch}
        onPress={() =>
          navigation.navigate("UpdateBook", {
            bookId: "123",
          })
        }
      >
        <Text>Update book</Text>
      </TouchableOpacity>
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
