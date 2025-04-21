import React from "react";
import { View, Text, StyleSheet } from "react-native";
import { RouteProp, useRoute } from "@react-navigation/native";
import { HomeStackParamsList } from "../navigations/types";

type DetailsRouteProp = RouteProp<HomeStackParamsList, "Details">;

const DetailsScreen = () => {
  const route = useRoute<DetailsRouteProp>();
  const { userId } = route.params;
  return (
    <View>
      <Text style={styles.title}>Details Book</Text>
      <Text>User id: {userId}</Text>
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
