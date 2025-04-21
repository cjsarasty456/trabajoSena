import React from "react";
import { View, Text, TouchableOpacity, StyleSheet } from "react-native";
import { useNavigation } from "@react-navigation/native";

import { HomeStackParamsList } from "../navigations/types";
import { NativeStackNavigationProp } from "@react-navigation/native-stack";

// type HomeScreenNavigationProp = NativeStackNavigationProp<
//   HomeStackParamsList,
//   "Home"
// >;

const AddBookScreen = () => {
  //   const navigation = useNavigation<HomeScreenNavigationProp>();
  return (
    <View>
      <Text style={styles.title}>Add Book</Text>
    </View>
  );
};
//         style={styles.touch}
//         onPress={() => navigation.navigate("Stack")}
//       >
//         <Text>Stacks</Text>
//       </TouchableOpacity>
//       <TouchableOpacity
//         style={styles.touch}
//         onPress={() => navigation.navigate("Details", { userId: "1" })}
//       >
//         <Text>Details 1</Text>
//       </TouchableOpacity>
//       <TouchableOpacity
//         style={styles.touch}
//         onPress={() => navigation.navigate("Details", { userId: "2" })}
//       >
//         <Text>Details 2</Text>
//       </TouchableOpacity>

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

export default AddBookScreen;
