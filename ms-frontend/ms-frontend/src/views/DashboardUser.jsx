import { useEffect, useState } from "react";
import { getAllCustomers } from "../services/ApiCustomer.js";

const DashboardUser = () => {
  const [customers, setCustomers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    getAllCustomers()
      .then((data) => {
        setCustomers(data);
        setLoading(false);
      })
      .catch((err) => {
        console.error(err);
        setLoading(false);
      });
  }, []);

  if (loading)
    return <div className="text-center p-10">Cargando clientes...</div>;

  return (
    <div className="overflow-x-auto">
      <h2 className="text-2xl font-bold mb-6 text-gray-800">
        Listado de Clientes
      </h2>
      <table className="min-w-full bg-white border border-gray-200 shadow-sm rounded-lg">
        <thead className="bg-gray-50">
          <tr>
            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
              Nombre
            </th>
            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
              RUT
            </th>
          </tr>
        </thead>
        <tbody className="divide-y divide-gray-200">
          {customers.map((customer) => (
            <tr
              key={customer.rut}
              className="hover:bg-gray-50 transition-colors"
            >
              <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900">
                {customer.name}
              </td>
              <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                {customer.rut}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      {customers.length === 0 && (
        <p className="text-center py-4 text-gray-500">
          No hay clientes registrados.
        </p>
      )}
    </div>
  );
};

export default DashboardUser;
