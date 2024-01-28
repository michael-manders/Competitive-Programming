import React, { useState } from "react";

import Navbar from "../components/Navbar";
import "../assets/css/Settings.css";
import ReactDOMServer from "react-dom/server";

const TextInputBox = () => {
    const [inputValue, setInputValue] = useState("");

    const handleInputChange = (e) => {
        setInputValue(e.target.value);
    };

    return (
        <div>
            <label htmlFor="textInput"></label>
            <input
                type="text"
                id="textInput"
                value={inputValue}
                onChange={handleInputChange}
            />
        </div>
    );
};
const DynamicSlider = ({ min, max }) => {
    const [sliderValue, setSliderValue] = useState((max - min) / 2 + min); // Initial slider value

    const handleSliderChange = (event) => {
        setSliderValue(event.target.value);
    };

    return (
        <div className="dynamicSliderContainer">
            <label htmlFor="dynamic-slider"> </label>
            <input
                type="number"
                id="dynamic-slider"
                min={min}
                max={max}
                value={sliderValue}
                onChange={handleSliderChange}
            />
        </div>
    );
};

const DynamicColorPicker = () => {
    const [color, setColor] = useState("#000000");

    const handleColorChange = (e) => {
        setColor(e.target.value);
    };

    return (
        <div className="dynamicColorPickerContainer">
            <label htmlFor="dynamic-color-picker"> </label>
            <input
                type="color"
                id="dynamic-color-picker"
                value={color}
                onChange={handleColorChange}
            />
        </div>
    );
};

const DynamicBoolean = () => {
    const [bool, setBool] = useState(false);

    const handleBoolChange = (e) => {
        setBool(e.target.value);
    };

    return (
        <div className="dynamicBooleanContainer">
            <label htmlFor="dynamic-boolean"> </label>
            <input
                type="checkbox"
                id="dynamic-boolean"
                value={bool}
                onChange={handleBoolChange}
            />
        </div>
    );
};

const SettingContainer = ({ name, type, value, unit }) => {
    return (
        <div className="settings-container">
            <div className="line2"></div>
            <div className="setting">
                <div className="setting-name">{name}</div>
                <div className="setting-value">
                    {type === "number" ? (
                        <DynamicSlider min={0} max={100} />
                    ) : type === "color" ? (
                        <DynamicColorPicker />
                    ) : type === "boolean" ? (
                        <DynamicBoolean />
                    ) : (
                        <TextInputBox />
                    )}
                </div>
                <div className="setting-unit">{unit}</div>
            </div>
            {/* <div className="line2"></div> */}
        </div>
    );
};

export default class Settings extends React.Component {
    componentDidMount() {
        const pages = {
            Window: [
                {
                    name: "CO2 cutoff",
                    type: "number",
                    value: 1000,
                    unit: "ppm",
                },
                { name: "VOC cutoff", type: "number", value: 400, unit: "ppm" },
                {
                    name: "Rain threshold",
                    type: "number",
                    value: 100,
                    unit: "%",
                },
            ],
            Lights: [
                { name: "Lights enable", type: "boolean", value: true },
                { name: "light color", type: "color", value: "#ff0000" },
            ],
            Climate: [
                {
                    name: "Temperature cutoff",
                    type: "number",
                    value: 20,
                    unit: "°C",
                },
                {
                    name: "Humidity cutoff",
                    type: "number",
                    value: 50,
                    unit: "%",
                },
            ],
        };

        this.addOptions(pages["Window"]);

        let options = document.querySelectorAll(".selection");

        for (let option of options) {
            option.addEventListener("click", () => {
                for (let option of options) {
                    option.classList.remove("selected");
                }

                option.classList.add("selected");

                let container = document.getElementById("settings-container");
                container.innerHTML = "";

                container.innerHTML = this.addOptions(pages[option.innerHTML]);

                const children =
                    container.children[container.children.length - 1].children;
                children[children.length - 1].innerHTML +=
                    "<div class='line2'></div>";
            });
        }
        let container = document.getElementById("settings-container");

        container.innerHTML = this.addOptions(pages["Window"]);
        const children =
            container.children[container.children.length - 1].children;
        children[children.length - 1].innerHTML += "<div class='line2'></div>";
    }

    componentWillUnmount() {
        // Remove event listeners when the component unmounts
        let options = document.querySelectorAll(".selection");

        for (let option of options) {
            option.removeEventListener("click", this.handleOptionClick);
        }
    }

    addOptions(options) {
        // Map each option to a SettingContainer component
        const settingComponents = options.map((option) => (
            <SettingContainer
                key={option.name} // Ensure each component has a unique key
                name={option.name}
                type={option.type}
                value={option.value}
                unit={option.unit}
            />
        ));

        // Render the components to HTML markup
        const htmlMarkup = ReactDOMServer.renderToString(
            <div className="settings-container-container">
                {settingComponents}
            </div>
        );

        return htmlMarkup;
    }

    setSettings() {
        let selected = "";

        for (let option of document.querySelectorAll(".selection")) {
            if (option.classList.contains("selected")) {
                selected = option.innerHTML;
                break;
            }
        }
    }

    render() {
        return (
            <div id="Settings-Class">
                <Navbar />
                <div id="settings">
                    <div id="st-container">
                        <div id="settings-selector">
                            <div className="line"></div>
                            <div className="selection selected">Window</div>
                            <div className="line"></div>
                            <div className="selection">Lights</div>
                            <div className="line"></div>
                            <div className="selection">Climate</div>
                            <div className="line"></div>
                        </div>
                        <div id="settings-container"></div>
                    </div>
                </div>
            </div>
        );
    }
    render() {
        const pages = {
            Window: [
                {
                    name: "CO2 cutoff",
                    type: "number",
                    value: 1000,
                    unit: "ppm",
                },
                { name: "VOC cutoff", type: "number", value: 400, unit: "ppm" },
                {
                    name: "Rain threshold",
                    type: "number",
                    value: 100,
                    unit: "%",
                },
            ],
            Lights: [
                { name: "Lights enable", type: "boolean", value: true },
                { name: "light color", type: "color", value: "#ff0000" },
            ],
            Climate: [
                {
                    name: "Temperature cutoff",
                    type: "number",
                    value: 20,
                    unit: "°C",
                },
                {
                    name: "Humidity cutoff",
                    type: "number",
                    value: 50,
                    unit: "%",
                },
            ],
        };

        const selectedPage = "Window"; // Example: Set the selected page

        // Get the options for the selected page
        const options = pages[selectedPage];

        return (
            <div id="Settings-Class">
                <Navbar />
                <div id="settings">
                    <div id="st-container">
                        <div id="settings-selector">
                            <div className="line"></div>
                            <div className="selection selected">Window</div>
                            <div className="line"></div>
                            <div className="selection">Lights</div>
                            <div className="line"></div>
                            <div className="selection">Climate</div>
                            <div className="line"></div>
                        </div>
                        <div id="settings-container"></div>
                    </div>
                </div>
            </div>
        );
    }
}
