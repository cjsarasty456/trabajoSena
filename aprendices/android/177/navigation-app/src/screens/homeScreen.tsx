import { View, Text } from 'react-native';
import { Pressable, StyleSheet } from 'react-native';
import { NativeStackNavigationProp } from '@react-navigation/native-stack';
import { HomeStackParamsList } from '../navigations/types';
import { useNavigation } from '@react-navigation/native';

type HomeNavigationProps = NativeStackNavigationProp<
    HomeStackParamsList,
    "Home">;

export default function homeScreen() {
    const navitaion = useNavigation<HomeNavigationProps>();
    return (
        <View>
            <Text>Hello home Screen</Text>
            <Pressable
                onPress={() => navitaion.navigate("Details", { id: "1" })}
                style={style.pressable}>
                <Text>Details</Text>
            </Pressable>
        </View>
    );
}
const style = StyleSheet.create({
    pressable: {
        backgroundColor: '#76d7c4',
        width: 80,
    },
});