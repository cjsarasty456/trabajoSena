import React from "react";
import { View, Text } from "react-native";
import { RouteProp, useRoute } from "@react-navigation/native";
import { HomeStackParamsList } from "../navigations/types";

type DetailsRouteProp = RouteProp<HomeStackParamsList, "Details">;

const DetailsScreen = () => {
  const route = useRoute<DetailsRouteProp>();
  const { userId } = route.params;
  return (
    <View>
      <Text>Details Screen</Text>
      <Text>User id: {userId}</Text>
    </View>
  );
};

export default DetailsScreen;
