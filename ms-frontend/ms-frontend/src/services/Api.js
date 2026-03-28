const BASE_URL = "http://localhost:8085/api"; // La puerta de entrada (Gateway)

// Esta es una función "maestra" que usaremos para no repetir código
export const apiFetch = async (endpoint, options = {}) => {
  try {
    const response = await fetch(`${BASE_URL}${endpoint}`, {
      ...options,
      headers: {
        "Content-Type": "application/json",
        ...options.headers,
      },
    });

    // Si el backend responde con error (404, 500, etc.)
    if (!response.ok) {
      throw new Error(`Error en la petición: ${response.status}`);
    }

    return await response.json(); // Convertimos la respuesta a un objeto JS
  } catch (error) {
    console.error("Error de conexión:", error);
    throw error;
  }
};
