import React from "react";
import { View, Text, StyleSheet } from "react-native";
import { RouteProp, useRoute } from "@react-navigation/native";
import { BookStackParamsList } from "../navigations/types";

type DetailsRouteProp = RouteProp<BookStackParamsList, "DetailBook">;

const DetailsScreen = () => {
  const route = useRoute<DetailsRouteProp>();
  const { bookId } = route.params;
  return (
    <View>
      <Text style={styles.title}>Details Book</Text>
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

export default DetailsScreen;
