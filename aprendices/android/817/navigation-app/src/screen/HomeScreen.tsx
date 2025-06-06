import { NativeStackNavigationProp } from '@react-navigation/native-stack';
import { StatusBar } from 'expo-status-bar';
import { Pressable, StyleSheet, Text, View } from 'react-native';
import { HomeStackParamsList } from '../navigation/types';
import { useNavigation } from '@react-navigation/native';
type HomeScreenNavigationProps=NativeStackNavigationProp<
HomeStackParamsList,"Home"
>

export default function HomeScreen() {
  const navigation=useNavigation<HomeScreenNavigationProps>();
  return (
    <View style={styles.container}>
      <Text>Hello Home Screen</Text>
      
      <Pressable style={styles.pressable}
      onPress={()=>navigation.navigate("Stack")}
      // onPress={}
      // onPressOut={()=>alert("hola mundo")}
      >
        <Text>Stack</Text>
      </Pressable>
      <Pressable style={styles.pressable}
      onPress={()=>navigation.navigate("Details",{id:"1"})}
      >
        <Text>Details 1</Text>
      </Pressable >
      <Pressable style={styles.pressable}
      onPress={()=>navigation.navigate("Details",{id:"2"})}
      >
        <Text>Details 2</Text>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#76d7c4',
    alignItems: 'center',
    justifyContent: 'center',
  },
  pressable:{
    borderColor:'#000000',
    borderWidth:0.5,
    marginTop:5,
    backgroundColor:'#e6b0aa',
    padding:5,
    paddingLeft:30,
    width:100,
    borderRadius:10,
  }
});
