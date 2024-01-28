import React from "react";

import "../assets/css/Homepage.css";

import Navbar from "../components/Navbar";

// import graph, bot, phone from react-icons
import { GoBeaker } from "react-icons/go";
import { GoLightBulb } from "react-icons/go";
import { GoAlert } from "react-icons/go";

const Home = () => {
    return (
        <div id="home">
            <Navbar />
            <div className="container">
                <div id="about">
                    <div id="mission">
                        <div id="text">
                            Air regulation that allows for{" "}
                            <span className="color">cleaner and greener</span>{" "}
                            air.{" "}
                        </div>
                    </div>
                    <div id="vision">
                        <div id="text">
                            Utilizing windows to keep the{" "}
                            <span className="color">safest levels</span> of CO
                            <sub>2</sub> and volatile organic compounds in your
                            spaces. Smart temperature regulation to{" "}
                            <span className="color">
                                reduce energy consumption{" "}
                            </span>{" "}
                            used by central heating.
                        </div>
                    </div>
                </div>
                <div id="about-scroll">
                    <div id="selector">
                        <div id="line"></div>
                        <div id="icons">
                            <div className="icon one ">
                                <GoBeaker
                                    size="48px"
                                    color="var(--background)"
                                />
                                <div className="tooltip">
                                    <div className="title-tt">
                                        CO2 Regulation
                                    </div>
                                    <div className="text">
                                        Lower-dose chronic exposure of CO2 leads
                                        to impaired cognitive function and a
                                        range of other potential adverse effects
                                        on the lungs, kidneys and bones.
                                    </div>
                                </div>
                            </div>
                            <div className="icon two">
                                <GoLightBulb
                                    size="48px"
                                    color="var(--background)"
                                />
                                <div className="tooltip">
                                    <div className="title-tt">
                                        Energy efficiency
                                    </div>
                                    <div className="text">
                                        HVAC system uses the most energy of any
                                        single appliance or system at 46 percent
                                        of the average U.S. home's energy
                                        consumption. By using the outdoors to
                                        regulate our homes, significant energy
                                        can be saved.
                                    </div>
                                </div>
                            </div>
                            <div className="icon three">
                                <GoAlert
                                    size="48px"
                                    color="var(--background)"
                                />
                                <div className="tooltip">
                                    <div className="title-tt">
                                        Clear visualization
                                    </div>
                                    <div className="text sub">
                                        Using our web feature, you can be
                                        updated with levels of CO<sub>2</sub>,
                                        volatile organic compounds, humidity,
                                        and temperature at any time.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Home;
