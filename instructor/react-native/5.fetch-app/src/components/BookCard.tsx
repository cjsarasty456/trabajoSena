import { View, Text, StyleSheet, TouchableOpacity } from "react-native";
import { IBook } from "../api/types/IBook";

interface Props {
  book: IBook;
}

const BookCard = ({ book }: Props) => {
  return (
    <View style={styles.card}>
      <Text>Titulo: {book.title}</Text>
      <Text>Autor: {book.author}</Text>
      <Text>Publicador: {book.publisher}</Text>
      <Text>ISBN: {book.isbn}</Text>

      <View style={styles.buttonContainer}>
        <TouchableOpacity style={styles.buttonEditar}>
          <Text style={styles.buttonText}>Editar</Text>
        </TouchableOpacity>

        <TouchableOpacity style={styles.buttonEliminar}>
          <Text style={styles.buttonText}>Eliminar</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  card: {
    flex: 1,
    backgroundColor: "#fff",
    borderRadius: 10,
    padding: 15,
    margin: 8,
    minHeight: 200,
    justifyContent: "space-between",
  },
  buttonContainer: {
    flexDirection: "row",
    marginTop: 20,
  },
  buttonEditar: {
    flex: 1,
    backgroundColor: "#b74125",
    marginRight: 5,
    paddingVertical: 10,
    borderRadius: 10,
    alignItems: "center",
  },
  buttonEliminar: {
    flex: 1,
    backgroundColor: "#d9534f",
    marginLeft: 5,
    paddingVertical: 10,
    borderRadius: 10,
    alignItems: "center",
  },
  buttonText: {
    color: "#fff",
    fontWeight: "bold",
  },
});

export default BookCard;
