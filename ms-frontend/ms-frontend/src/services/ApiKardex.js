import { apiFetch } from "./Api.js";

export const getAuditLogs = () => {
  return apiFetch("/kardex/eventos"); // Llama a http://localhost:8085/api/kardex/eventos
};
