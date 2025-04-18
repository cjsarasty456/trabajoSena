import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, useColorScheme } from 'react-native';
import { CheckBox } from 'react-native-web';

export default function App() {
  const colorScheme = useColorScheme();  // "light" o "dark"
  // Estilos para el modo claro y oscuro
  const styles = colorScheme === 'dark' ? darkStyles : lightStyles;
  return (
    <View style={styles.container}>
      <Text style={styles.text}>      El dispositivo está en modo {colorScheme === 'dark' ? 'oscuro' : 'claro'}.</Text>
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
});

const lightStyles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#ffffff',
  },
  text: {
    fontSize: 20,
    color: '#000000',
  },
});

const darkStyles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#000000',
  },
  text: {
    fontSize: 20,
    color: '#ffffff',
  },
});
