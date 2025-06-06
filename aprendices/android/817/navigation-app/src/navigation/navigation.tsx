import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStaticNavigation, NavigationContainer } from "@react-navigation/native";


//import screen
import DetailsScreen from "../screen/DetailsScreen";
import HomeScreen from "../screen/HomeScreen";
import SettingScreen from "../screen/SettingScreen";
import StackScreen from "../screen/StackScreen";

//icon
import AntDesign from '@expo/vector-icons/AntDesign';
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

//crear el objeto createBottomTabNavigation
const Tab = createBottomTabNavigator();

function MyTabs() {
    return (
        <Tab.Navigator>
            <Tab.Screen name="Home" component={MyStack}
                options={
                    {
                        headerShown: false,
                        tabBarIcon: ({ color, size }) => (
                            <AntDesign name="home" size={24} color="black" />
                        )
                    }
                } />
            <Tab.Screen name="Setting" component={SettingScreen} />
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