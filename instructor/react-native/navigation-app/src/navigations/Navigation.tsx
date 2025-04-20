import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";


//import screens
import HomeScreen from "../screens/HomeScreen";
import SettingsScreen from "../screens/SettingScreen";
import StackScreen from "../screens/StackScreen";

//import icon
import AntDesign from "@expo/vector-icons/AntDesign";
import DetailsScreen from "../screens/DetailsScreen";

//import stack
import { createNativeStackNavigator } from "@react-navigation/native-stack";

const HomeStackNavigator = createNativeStackNavigator();

function MyStack() {
  return (
    <HomeStackNavigator.Navigator initialRouteName="Home">
      <HomeStackNavigator.Screen name="Home" component={HomeScreen} />
      <HomeStackNavigator.Screen name="Stack" component={StackScreen} />
      <HomeStackNavigator.Screen name="Details" component={DetailsScreen} />
    </HomeStackNavigator.Navigator>
  );
}

//instance for createBottomTabNavigator
const Tab = createBottomTabNavigator();

function MyTabs() {
  return (
    <Tab.Navigator
      initialRouteName="Home"
      screenOptions={{ tabBarActiveTintColor: "purple" }}
    >
      <Tab.Screen
        name="Home"
        component={MyStack}
        options={{
          tabBarLabel: "Home",
          headerShown: false,
          tabBarIcon: ({ color, size }) => (
            <AntDesign name="home" size={24} color="black" />
          ),
          tabBarBadge: 5,
        }}
      />
      <Tab.Screen
        name="Setting"
        component={SettingsScreen}
        options={{
          tabBarLabel: "Setting",
          headerShown: false,
          tabBarIcon: ({ color, size }) => (
            <AntDesign name="setting" size={24} color="black" />
          ),
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
