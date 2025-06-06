import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Image,ScrollView  } from 'react-native';
// import { Colors } from 'react-native/Libraries/NewAppScreen';
// import { ScrollView } from 'react-native-web';
import image1 from './assets/image/image1.jpg';

export default function App() {
  return (
    <ScrollView>
      <View style={styles.container}>
        <Text >Primer texto</Text>
        <Text>segundo texto</Text>
        <Image
          style={styles.image}
          source={{
            uri: 'https://cdn-icons-png.flaticon.com/512/5650/5650378.png'
          }}
        />
        <Image
          style={styles.image}
          source={{
            uri: 'https://www.shutterstock.com/image-vector/goofy-cartoon-character-created-by-600nw-2524180789.jpg'
          }}
        />
        <Image
          style={styles.image}
          source={image1}
        />
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
  image: {
    width: 300,
    height: 300,
  },

});
