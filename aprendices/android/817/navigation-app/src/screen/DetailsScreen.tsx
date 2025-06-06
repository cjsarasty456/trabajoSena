import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';

export default function DetailsScreen() {
  return (
    <View style={styles.container}>
      <Text>Hello Details Screen</Text>
      <Text>id user= </Text>
      <StatusBar style="auto" />
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
});
