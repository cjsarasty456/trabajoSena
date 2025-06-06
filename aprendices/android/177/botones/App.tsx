import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Button, TouchableHighlight } from 'react-native';

/*
Se crearán elementos touchable o elementos que tenga acción toque o clic
*/

export default function App() {
  const onPress = () => {
    alert("Segundo hola");
  }
  return (
    <View style={styles.container}>
      <Button
        title="saludar"
        onPress={() => alert("Hola mundo")}
      />
      <TouchableHighlight 
      onPress={onPress}
      underlayColor="#45b39d"
      style={{backgroundColor:"#eaf2f8", }}
      activeOpacity={0.1}
      
      >
        <View style={styles.button}>
          <Text>Touch highlight</Text>
        </View>
      </TouchableHighlight>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
    button: {
    alignItems: 'center',
    backgroundColor: '#48c9b0 ',
    padding: 10,
  },
});
