//import the screens
import homeScreen from './../screens/homeScreen';
import detailsScreen from './../screens/detailsScreen';
import stacksScreen from './../screens/stacksScreen';
import settingScreen from './../screens/settingScreen';

import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";

//importación icono:
import AntDesign from '@expo/vector-icons/AntDesign';

//import stack
import { createNativeStackNavigator } from "@react-navigation/native-stack";

//crear objeto del bottom menu
const Tab = createBottomTabNavigator();


//crear la función cargar el objeto tab
function MyTabs() {
    return (

        <Tab.Navigator>
            <Tab.Screen name="Home" component={MyStack}

                options={{
                    headerLeft: () => <AntDesign name="home" size={24} color="black" />,
                    tabBarIcon: ({ color, size }) => (
                        <AntDesign name="home" size={24} color="black" />
                    ),
                    tabBarBadge: 10
                }
                }

            />
            <Tab.Screen name="Setting" component={settingScreen} />
        </Tab.Navigator>
    );
}

const HomeStackNavigator = createNativeStackNavigator();
function MyStack() {
    return (
        <HomeStackNavigator.Navigator initialRouteName="Home">
            <HomeStackNavigator.Screen name="Home" component={homeScreen} />
            <HomeStackNavigator.Screen name="Stack" component={stacksScreen} />
            <HomeStackNavigator.Screen name="Details" component={detailsScreen} />
        </HomeStackNavigator.Navigator>
    );
}

export default function navigation() {
    return (<NavigationContainer>
        <MyTabs />
    </NavigationContainer>);

}

