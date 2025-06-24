import React, { useEffect, useState } from "react";

const UpdateForm = ({ apiUrl, fields, item, idKey = "id", onSuccess, onCancel }) => {
  const [formData, setFormData] = useState({});
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");


  useEffect(() => {
    setFormData(item || {});
  }, [item]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setLoading(true);
    setError("");
    const id = item?.[idKey];
    if (!id) {
      console.error(`ID '${idKey}' no encontrado en el item`, item);
      return;
    }
    if ("email" in formData) {
      const emailValue = formData.email.trim();
      const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

      if (!emailRegex.test(emailValue)) {
        setError("Invalid email format.");
        setLoading(false);
        return; // Detener el envío
        // Aquí puedes lanzar un error, mostrar un mensaje o lo que necesites
      }
    }
    if ("phone_number" in formData) {
      const phoneValue = formData.phone_number.toString(); // Aseguramos que sea string
      if (phoneValue.length !== 10) {
        setError("The phone number must have exactly 10 digits.");
        setLoading(false);
        return; // Detener el envío
      }
    }

    fetch(`${apiUrl}${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formData),
    })
      .then((res) => res.json())
      .then(() => {
        onSuccess();
      })
      .catch((err) => console.error("Error al actualizar:", err));
  };

  return (
    <div className="fixed inset-0 bg-black/70 flex items-center justify-center z-50 ">
      <form onSubmit={handleSubmit} className="space-y-4 bg-white p-6 rounded-lg shadow w-3xl">
        <h1 className="text-center font-bold text-2xl p-4">Update Record </h1>

        {fields.map((field) => (
          <div key={field.name}>
            <label className="block text-sm font-medium mb-1">
              {field.label}
              {field.required && <span className="text-red-500 ml-1">*</span>}
            </label>
            {field.type === "select" ? (
              <select
                name={field.name}
                required={field.required}
                value={formData[field.name] || ""}
                onChange={handleChange}
                disabled={field.disabled}
                className="w-full p-2 border border-gray-300 rounded bg-white disabled:opacity-70"
              >
                {field.options?.map((option) => (
                  <option key={option.value} value={option.value}>
                    {option.label}
                  </option>
                ))}
              </select>
            ) : (
              <input
                type={field.type || "text"}
                name={field.name}
                required={field.required}
                value={formData[field.name] || ""}
                onChange={handleChange}
                disabled={field.disabled}
                className="w-full p-2 border border-gray-300 rounded bg-white disabled:opacity-70"
              />
            )}
          </div>
        ))}
        {error && <p className="text-red-500 mb-2">{error}</p>}
        <div className="flex justify-end space-x-4">
          <button type="button" onClick={onCancel}
            className="bg-gray-300 px-4 py-2 rounded">
            Cancel
          </button>
          <button type="submit" disabled={loading} className="bg-blue-600 text-white px-4 py-2 rounded" >
            {loading ? "Saving..." : ""}

            Update
          </button>

        </div>
      </form>
    </div>
  );
};

export default UpdateForm;
