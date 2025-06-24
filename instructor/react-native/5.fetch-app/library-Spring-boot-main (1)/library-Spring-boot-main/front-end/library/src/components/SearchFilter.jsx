import React, { useState } from 'react';
import buscar from "../assets/img/buscar.png";

const SearchFilter = ({ apiUrl, onFilter }) => {
  const [filter, setFilter] = useState('');

  const handleSearch = () => {
    if (filter.trim()) {  // Asegúrate de que el filtro no esté vacío
      fetch(`${apiUrl}search/${filter}`)
        .then((res) => res.json())
        .then((data) => {
          onFilter(data); // Llamamos al callback 'onFilter' para pasar los datos filtrados al componente principal
        })
        .catch((error) => console.error('Error to get dates :', error));
    } else {
      console.log('void filter');
    }
  };
  const handleKeyPress = (e) => {
    if (e.key === 'Enter') {
        handleSearch();
    }
}
  return (
  
    <div className="mx-auto mt-5 rounded-lg max-w-[35rem] w-full bg-amber-50 h-8 flex items-center">
      <input
        type="text"
        placeholder="Search..."
        value={filter}
        onChange={(e) => setFilter(e.target.value)}
        className="w-full h-8 p-2 rounded-l-lg border-none"
        onKeyDown={handleKeyPress}
      />
      <button
        onClick={handleSearch}
        className="text-white p-2 rounded-r-lg hover:bg-orange-200"
      >
        <img src={buscar} alt="Search" className="w-6 h-6" />
      </button>
    </div>
  );
};

export default SearchFilter;
