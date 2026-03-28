import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import DashboardUser from "./views/DashboardUser.jsx";
import DashboardAdmin from "./views/DashboardAdmin.jsx";

function App() {
  return (
    <Router>
      <div className="min-h-screen bg-gray-100 flex flex-col">
        <nav className="bg-white shadow-md p-4 flex gap-8 justify-center border-b border-gray-200">
          <Link
            to="/"
            className="text-gray-700 hover:text-blue-600 font-semibold transition-colors"
          >
            👥 Panel de Usuario
          </Link>
          <Link
            to="/admin"
            className="text-gray-700 hover:text-blue-600 font-semibold transition-colors"
          >
            ⚙️ Panel de Admin
          </Link>
        </nav>

        <main className="flex-grow p-6">
          <div>
            <Routes>
              <Route path="/" element={<DashboardUser />} />
              <Route path="/admin" element={<DashboardAdmin />} />
            </Routes>
          </div>
        </main>
        <footer className="p-4 text-center text-gray-400 text-sm">
          Cloud Prac - Microservicios Frontend 2026
        </footer>
      </div>
    </Router>
  );
}

export default App;
