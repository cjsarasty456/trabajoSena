import { StatusBar } from 'expo-status-bar';
import { Image, StyleSheet, Text, View, ScrollView } from 'react-native';

//import images
import image1 from './assets/images/image1.png';
import icon from './assets/icon.png';


export default function App() {
  return (
    <ScrollView>
      <View style={styles.container}>
        <Text>external image</Text>
        <Image
          source={{
            uri: "https://concepto.de/wp-content/uploads/2020/08/Programacion-informatica-scaled-e1724960033513.jpg"
          }}
          defaultSource={icon}
          style={{
            width: 400,//ancho de la imagen en pixeles
            height: 400,//alto de la imagen en pixeles
            resizeMode: 'center'
          }
          }
        ></Image>
        <Text>contain</Text>
        <Image
          fa
          source={image1}
          style={{
            width: 400,//ancho de la imagen en pixeles
            height: 400,//alto de la imagen en pixeles
            resizeMode: 'contain'
          }
          }
        ></Image>
        <Text>cover</Text>
        <Image
          source={image1}
          style={{
            width: 400,//ancho de la imagen en pixeles
            height: 400,//alto de la imagen en pixeles
            resizeMode: 'cover'
          }
          }
        ></Image>
        <Text>stretch</Text>
        <Image
          source={image1}
          style={{
            width: 400,//ancho de la imagen en pixeles
            height: 400,//alto de la imagen en pixeles
            resizeMode: 'stretch'
          }
          }
        ></Image>
        <Text>center</Text>
        <Image
          source={image1}
          style={{
            width: 400,//ancho de la imagen en pixeles
            height: 400,//alto de la imagen en pixeles
            resizeMode: 'center'
          }
          }
        ></Image>

        <StatusBar style="auto" />
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
});
