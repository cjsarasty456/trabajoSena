import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Button, StyleSheet, Text, TouchableHighlight, TouchableOpacity, View } from 'react-native';

export default function App() {
  const saludar = () => {
    alert("hola mundo")
  }
  const [count, setCount] = useState(0);
  const onPress = () => setCount(prevCount => prevCount + 1);
  return (
    <View style={styles.container}>
      <Text>Open up App.tsx to start working on your app!</Text>
      <Button
        color='#39e298'
        title='Saludar'
        // onPress={() => alert("hola mundo")}
        onPress={() => saludar()}
      />
      <View style={styles.countContainer}>
        <Text>Count: {count}</Text>
      </View>
      <TouchableOpacity style={styles.button} onPress={onPress}
      
      >
        <Text style={{color:'#ffffff'}}>Press Here</Text>
      </TouchableOpacity>
       <TouchableHighlight style={styles.button} onPress={onPress}
        underlayColor='#FA8072'
      >
        <Text style={{color:'#ffffff'}}>Press Here</Text>
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
    backgroundColor: '#000000',
    padding: 10,
    
  },

  countContainer: {
    alignItems: 'center',
    padding: 10,
  },
});
