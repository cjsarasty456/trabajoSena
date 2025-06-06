import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View,Image,ScrollView } from 'react-native';
import imagen1 from './assets/image/imagen1.jpg';

export default function App() {
  return (
    <ScrollView>
    <View style={styles.container}>
        <Image
          fadeDuration={100}
          style={styles.image}
          source={{uri: 'https://images.vexels.com/media/users/3/271649/isolated/preview/3a1938ea55f27c31d53b585fcebdcd5e-icono-de-dibujos-animados-de-libro-abierto.png'}}
        ></Image>
         <Image
          fadeDuration={2000}
          style={styles.image}
          source={imagen1}
        ></Image>
        </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  image:{
    width:500,
    height:500,
  },
});
