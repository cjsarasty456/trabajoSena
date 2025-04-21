import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";

//import screens
import ListBookScreen from "../screens/ListBookScreen";
import AddBookScreen from "../screens/AddBookScreen";
import DetailsScreen from "../screens/DetailsBookScreen";
import UpdateBookScreen from "../screens/UpdateBookScreen";

//import icon
import MaterialCommunityIcons from "@expo/vector-icons/MaterialCommunityIcons";

//import stack
import { createNativeStackNavigator } from "@react-navigation/native-stack";

const BookStackNavigator = createNativeStackNavigator();

function MyStack() {
  return (
    <BookStackNavigator.Navigator initialRouteName="ListBook">
      <BookStackNavigator.Screen name="ListBook" component={ListBookScreen} />
      <BookStackNavigator.Screen name="AddBook" component={AddBookScreen} />
      <BookStackNavigator.Screen name="DetailBook" component={DetailsScreen} />
      <BookStackNavigator.Screen
        name="UpdateBook"
        component={UpdateBookScreen}
      />
    </BookStackNavigator.Navigator>
  );
}

//instance for createBottomTabNavigator
const Tab = createBottomTabNavigator();

function MyTabs() {
  return (
    <Tab.Navigator
      initialRouteName="ListBook"
      screenOptions={{ tabBarActiveTintColor: "purple" }}
    >
      <Tab.Screen
        name="ListBook"
        component={MyStack}
        options={{
          tabBarLabel: "List Book",
          headerShown: false,
          tabBarIcon: ({ color, size }) => (
            <MaterialCommunityIcons name="bookshelf" size={24} color="black" />
          ),
          // tabBarBadge: 5,
        }}
      />
    </Tab.Navigator>
  );
}

export default function Navigation() {
  return (
    <NavigationContainer>
      <MyTabs />
    </NavigationContainer>
  );
}
