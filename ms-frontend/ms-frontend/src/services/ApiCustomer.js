import { apiFetch } from "./Api.js";

export const getAllCustomers = () => {
  return apiFetch("/customers"); // Llama a http://localhost:8085/api/customers
};

export const createCustomer = (nuevoCliente) => {
  return apiFetch("/customers", {
    method: "POST",
    body: JSON.stringify(nuevoCliente),
  });
};
