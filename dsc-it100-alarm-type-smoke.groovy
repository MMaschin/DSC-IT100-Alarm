/**
 *  DSC-IT100-Alarm Panel
 *
 *  Author: Matt Maschinot
 *  
 *  Date: 04/10/2019
 */

// for the UI
metadata {
  definition (name: "DSC-IT100-Alarm-Type-Smoke", namespace: "mmaschin/DSCIT100Alarm", author: "mmaschin@gmail.com") {
    // Change or define capabilities here as needed
    capability "Smoke Detector"
    capability "Sensor"
    capability "Refresh"
    capability "Polling"

	attribute "switch", "string"
    
    command "updatedevicezone"
  }

  simulator {
    // Nothing here, you could put some testing stuff here if you like
  }

  tiles {
    // Main Row
  
    multiAttributeTile(name:"zone", type: "generic", width: 2, height: 2, canChangeIcon: true) {
        tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
            	// Regular
                attributeState("detected", label:'SMOKE', icon:"st.alarm.smoke.smoke", backgroundColor:"#ee0000")
				attributeState("clear", label:'CLEAR', icon:"st.alarm.smoke.clear", backgroundColor:"#ffffff")
                attributeState("0",   label:"", defaultState: true, backgroundColor: "#ffffff")
//                attributeState("1",   label:"1",  icon:"st.alarm.smoke.smoke", backgroundColor: "#ee0000")
                attributeState("1",   label:"1", backgroundColor: "#ee0000")
                attributeState("2",   label:"2", backgroundColor: "#ee0000")
                attributeState("3",   label:"3", backgroundColor: "#ee0000")
                attributeState("4",   label:"4", backgroundColor: "#ee0000")
                attributeState("5",   label:"5", backgroundColor: "#ee0000")
                attributeState("6",   label:"6", backgroundColor: "#ee0000")
                attributeState("7",   label:"7", backgroundColor: "#ee0000")
                attributeState("8",   label:"8", backgroundColor: "#ee0000")
                attributeState("9",   label:"9", backgroundColor: "#ee0000")
                attributeState("10",  label:"10", backgroundColor: "#ee0000")
                attributeState("11",  label:"11", backgroundColor: "#ee0000")
                attributeState("12",  label:"12", backgroundColor: "#ee0000")
                attributeState("13",  label:"13", backgroundColor: "#ee0000")
                attributeState("14",  label:"14", backgroundColor: "#ee0000")
                attributeState("15",  label:"15", backgroundColor: "#ee0000")
                attributeState("16",  label:"16", backgroundColor: "#ee0000")
                attributeState("17",  label:"17", backgroundColor: "#ee0000")
                attributeState("18",  label:"18", backgroundColor: "#ee0000")
                attributeState("19",  label:"19", backgroundColor: "#ee0000")
                attributeState("20",  label:"20", backgroundColor: "#ee0000")
                attributeState("21",  label:"21", backgroundColor: "#ee0000")
                attributeState("22",  label:"22", backgroundColor: "#ee0000")
                attributeState("23",  label:"23", backgroundColor: "#ee0000")
                attributeState("24",  label:"24", backgroundColor: "#ee0000")
                attributeState("25",  label:"25", backgroundColor: "#ee0000")
                attributeState("26",  label:"26", backgroundColor: "#ee0000")
                attributeState("27",  label:"27", backgroundColor: "#ee0000")
                attributeState("28",  label:"28", backgroundColor: "#ee0000")
                attributeState("29",  label:"29", backgroundColor: "#ee0000")
                attributeState("30",  label:"30", backgroundColor: "#ee0000")
                attributeState("31",  label:"31", backgroundColor: "#ee0000")
                attributeState("32",  label:"32", backgroundColor: "#ee0000")
                attributeState("33",  label:"33", backgroundColor: "#ee0000")
                attributeState("34",  label:"34", backgroundColor: "#ee0000")
                attributeState("35",  label:"35", backgroundColor: "#ee0000")
                attributeState("36",  label:"36", backgroundColor: "#ee0000")
                attributeState("37",  label:"37", backgroundColor: "#ee0000")
                attributeState("38",  label:"38", backgroundColor: "#ee0000")
                attributeState("39",  label:"39", backgroundColor: "#ee0000")
                attributeState("40",  label:"40", backgroundColor: "#ee0000")
                attributeState("41",  label:"41", backgroundColor: "#ee0000")
                attributeState("42",  label:"42", backgroundColor: "#ee0000")
                attributeState("43",  label:"43", backgroundColor: "#ee0000")
                attributeState("44",  label:"44", backgroundColor: "#ee0000")
                attributeState("45",  label:"45", backgroundColor: "#ee0000")
                attributeState("46",  label:"46", backgroundColor: "#ee0000")
                attributeState("47",  label:"47", backgroundColor: "#ee0000")
                attributeState("48",  label:"48", backgroundColor: "#ee0000")
                attributeState("49",  label:"49", backgroundColor: "#ee0000")
                attributeState("50",  label:"50", backgroundColor: "#ee0000")
                attributeState("51",  label:"51", backgroundColor: "#ee0000")
                attributeState("52",  label:"52", backgroundColor: "#ee0000")
                attributeState("53",  label:"53", backgroundColor: "#ee0000")
                attributeState("54",  label:"54", backgroundColor: "#ee0000")
                attributeState("55",  label:"55", backgroundColor: "#ee0000")
                attributeState("56",  label:"56", backgroundColor: "#ee0000")
                attributeState("57",  label:"57", backgroundColor: "#ee0000")
                attributeState("58",  label:"58", backgroundColor: "#ee0000")
                attributeState("59",  label:"59", backgroundColor: "#ee0000")
                attributeState("60",  label:"60", backgroundColor: "#ee0000")
                attributeState("61",  label:"61", backgroundColor: "#ee0000")
                attributeState("62",  label:"62", backgroundColor: "#ee0000")
                attributeState("63",  label:"63", backgroundColor: "#ee0000")
                attributeState("64",  label:"64", backgroundColor: "#ee0000")
                
        }
   	}

    // This tile will be the tile that is displayed on the Hub page.
    main "zone"

    // These tiles will be displayed when clicked on the device, in the order listed here.
    details(["zone"])
  }
}

// handle commands
def updatedevicezone(String cmd) {

    def zoneidx = cmd.substring(6,9)
    zoneidx = zoneidx.replaceAll("^0+","");

	if(cmd.substring(3,9).substring(0,3) == "609"){
		sendEvent (name: "switch", value: "detected", display: true, displayed: true, isStateChange: true)
	}
	else if (cmd.substring(3,9).substring(0,3) == "610"){
		sendEvent (name: "switch", value: "clear", display: true, displayed: true, isStateChange: true)
	}
}


//
def refresh() {

// TODO: handle 'refresh' command
}


//
def poll() { 

	refresh() 
}


//
private writeLog(message) {

	if(idelog){
    	log.debug "${message}"
  	}
}
