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

const HomeStackNavigator = createNativeStackNavigator();

// function MyStack() {
//   return (
//     <HomeStackNavigator.Navigator initialRouteName="Home">
//       <HomeStackNavigator.Screen name="Home" component={HomeScreen} />
//       <HomeStackNavigator.Screen name="Stack" component={StackScreen} />
//       <HomeStackNavigator.Screen name="Details" component={DetailsScreen} />
//     </HomeStackNavigator.Navigator>
//   );
// }

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
        component={ListBookScreen}
        options={{
          tabBarLabel: "List Book",
          headerShown: false,
          tabBarIcon: ({ color, size }) => (
            <MaterialCommunityIcons name="bookshelf" size={24} color="black" />
          ),
          // tabBarBadge: 5,
        }}
      />
      <Tab.Screen
        name="AddtBook"
        component={AddBookScreen}
        options={{
          tabBarLabel: "Add Book",
          headerShown: false,
          tabBarIcon: ({ color, size }) => (
            <MaterialCommunityIcons name="bookshelf" size={24} color="black" />
          ),
          // tabBarBadge: 5,
        }}
      />
      {/* <Tab.Screen
        name="Setting"
        component={SettingsScreen}
        options={{
          tabBarLabel: "Setting",
          headerShown: false,
          tabBarIcon: ({ color, size }) => (
            <AntDesign name="setting" size={24} color="black" />
          ),
        }}
      /> */}
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
