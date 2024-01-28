import React from "react";
import Cookies from "js-cookie";

import "../assets/css/Navbar.css";
import logo from "../assets/images/logo.png";
import logo_text from "../assets/images/logo-text.png";

export default class Navbar extends React.Component {
    componentDidMount() {
        var dropdown = document.getElementById("dropdown");
        var options = dropdown.getElementsByClassName("options");

        dropdown.addEventListener("mouseenter", () => {
            let i = 1;
            for (let option of options) {
                setTimeout(() => {
                    option.classList.add("show");
                }, i * 30);
                i++;
            }
        });

        dropdown.addEventListener("mouseleave", () => {
            let i = 1;
            for (let option of options) {
                setTimeout(() => {
                    option.classList.remove("show");
                }, i * 30);
                i++;
            }
        });

        for (let option of options) {
            option.addEventListener("click", () => {
                if (option.innerHTML === "Select Sensor") {
                    return;
                }

                if (option.innerHTML === "add sensor") {
                    window.location.href = "/settings";
                    return;
                }
                // store sensor id in cookie
                Cookies.set("sensor", option.innerHTML.split(" ")[1]);
                let i = 1;
                for (let option of options) {
                    setTimeout(() => {
                        option.classList.remove("show");
                    }, i * 30);
                    i++;
                }
            });
        }
    }

    render() {
        return (
            <div id="navbar">
                <div
                    id="logo"
                    onClick={() => {
                        window.location.href = "/";
                    }}>
                    <img src={logo} alt="logo" id="acorn" />
                    <div id="logo-text">Winda</div>
                </div>

                <div id="navlinks">
                    <a href="/" className="link">
                        Home
                    </a>
                    <a href="/statistics" className="link">
                        Statistics
                    </a>
                    <a href="/settings" className="link">
                        Settings
                    </a>
                </div>
                <div id="dropdown">
                    <div className="options">
                        <b>Select Sensor</b>
                    </div>
                    <div className="options">Sensor 1</div>
                    <div className="options">Sensor 2</div>
                    <div className="options">add sensor</div>
                </div>
            </div>
        );
    }
}
