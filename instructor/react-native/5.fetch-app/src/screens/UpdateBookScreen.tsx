import React from "react";
import { View, Text, StyleSheet } from "react-native";
import { RouteProp, useRoute } from "@react-navigation/native";
import { BookStackParamsList } from "../navigations/types";

type UpdateRouteProp = RouteProp<BookStackParamsList, "UpdateBook">;

const UpdateScreen = () => {
  const route = useRoute<UpdateRouteProp>();
  const { bookId } = route.params;
  return (
    <View>
      <Text style={styles.title}>Update Book</Text>
      <Text>Book id: {bookId}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  title: {
    fontSize: 50,
    textAlign: "center",
  },
});

export default UpdateScreen;
