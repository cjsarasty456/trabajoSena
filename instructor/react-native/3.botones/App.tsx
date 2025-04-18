import { StatusBar } from 'expo-status-bar';
import {
  StyleSheet,
  Text,
  View,
  Button,
  TextInput,
  TouchableHighlight,
  Pressable,
} from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <StatusBar style="auto" />
      <Button title="saludar" onPress={() => alert('Hola mundo')} />

      <TouchableHighlight
        underlayColor={'#af513c'}
        onPress={() => alert('Hola mundo 2')}
        style={styles.touchable}
      >
        <Text style={{ color: 'white' }}>Pulsa aqui</Text>
      </TouchableHighlight>
      <Pressable
        style={styles.Pressable}
        onPress={() => alert('pulsación corta')}
        onLongPress={() => alert('pulsación larga')}
      >
        <Text>Touch Pressable</Text>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#000',
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    color: '#ffffff',
  },
  touchable: {
    marginTop: 10,
    width: 100,
    height: 50,
    backgroundColor: '#f26c4f',
    borderRadius: 10,
    justifyContent: 'center',
    alignItems: 'center',
  },
  Pressable: {
    marginTop: 10,
    width: 100,
    height: 50,
    backgroundColor: '#a26c4f',
    borderRadius: 10,
    justifyContent: 'center',
    alignItems: 'center',
  },
});
