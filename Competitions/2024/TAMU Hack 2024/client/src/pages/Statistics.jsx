import React from "react";
import Navbar from "../components/Navbar";
import BarChart from "../components/BarChart";

import "../assets/css/Statistics.css";

const Statistics = () => {
    return (
        <div id="statistics">
            <Navbar />
            <div id="container">
                <div id="row">
                    <BarChart
                        width={600}
                        height={350}
                        barWidth={10}
                        filePath={"http://127.0.0.1:3001/co2"}
                        label={"CO2 ppm"}
                    />
                    <BarChart
                        width={600}
                        height={350}
                        barWidth={10}
                        filePath={"http://127.0.0.1:3001/tVOC"}
                        label={"VOC ppm"}
                    />
                </div>
                <div id="row">
                    <BarChart
                        width={600}
                        height={350}
                        barWidth={10}
                        filePath={"http://127.0.0.1:3001/temperature"}
                        label={"Fahrenheit"}
                    />
                    <BarChart
                        width={600}
                        height={350}
                        barWidth={10}
                        filePath={"http://127.0.0.1:3001/humidity"}
                        label={"Humidity (%)"}
                        max={100}
                    />
                </div>
            </div>
        </div>
    );
};

export default Statistics;
