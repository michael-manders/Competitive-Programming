import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./App.css";
import "chart.js/auto";

import Home from "./pages/Home";
import Visualization from "./pages/Visualization";
import Settings from "./pages/Settings";
import Statistics from "./pages/Statistics";
// import Chatbot from "./pages/Chatbot";
// import WorkOrders from "./pages/WorkOrders";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Home></Home>} />
                <Route path="/settings" element={<Settings></Settings>} />
                <Route path="/statistics" element={<Statistics></Statistics>} />
                {/* <Route path="/chatbot" element={<Chatbot></Chatbot>} />
                <Route path="/workorder" element={<WorkOrders></WorkOrders>} /> */}
            </Routes>
        </Router>
    );
}

export default App;
