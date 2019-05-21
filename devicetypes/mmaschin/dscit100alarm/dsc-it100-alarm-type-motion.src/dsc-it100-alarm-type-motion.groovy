/**
 *  DSC-IT100-Alarm Panel
 *
 *  Author: Matt Maschinot
 *  
 *  Date: 04/10/2019
 */

// for the UI
metadata {
  definition (name: "DSC-IT100-Alarm-Type-Motion", namespace: "mmaschin/DSCIT100Alarm", author: "mmaschin@gmail.com") {
    // Change or define capabilities here as needed
    capability "Motion Sensor"
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
                attributeState("active", label:'Motion', icon:"st.motion.motion.active", backgroundColor:"#55aacc")
				attributeState("inactive", label:'No Motion', icon:"st.motion.motion.inactive", backgroundColor:"#ffffff")
                attributeState("0",   label:"", backgroundColor: "#ffffff")
//                attributeState("1",   label:"1",  icon:"st.motion.motion.active", backgroundColor: "#55aacc")
                attributeState("1",   label:"1", backgroundColor: "#55aacc")
                attributeState("2",   label:"2", backgroundColor: "#55aacc")
                attributeState("3",   label:"3", backgroundColor: "#55aacc")
                attributeState("4",   label:"4", backgroundColor: "#55aacc")
                attributeState("5",   label:"5", backgroundColor: "#55aacc")
                attributeState("6",   label:"6", backgroundColor: "#55aacc")
                attributeState("7",   label:"7", backgroundColor: "#55aacc")
                attributeState("8",   label:"8", backgroundColor: "#55aacc")
                attributeState("9",   label:"9", backgroundColor: "#55aacc")
                attributeState("10",  label:"10", backgroundColor: "#55aacc")
                attributeState("11",  label:"11", backgroundColor: "#55aacc")
                attributeState("12",  label:"12", backgroundColor: "#55aacc")
                attributeState("13",  label:"13", backgroundColor: "#55aacc")
                attributeState("14",  label:"14", backgroundColor: "#55aacc")
                attributeState("15",  label:"15", backgroundColor: "#55aacc")
                attributeState("16",  label:"16", backgroundColor: "#55aacc")
                attributeState("17",  label:"17", backgroundColor: "#55aacc")
                attributeState("18",  label:"18", backgroundColor: "#55aacc")
                attributeState("19",  label:"19", backgroundColor: "#55aacc")
                attributeState("20",  label:"20", backgroundColor: "#55aacc")
                attributeState("21",  label:"21", backgroundColor: "#55aacc")
                attributeState("22",  label:"22", backgroundColor: "#55aacc")
                attributeState("23",  label:"23", backgroundColor: "#55aacc")
                attributeState("24",  label:"24", backgroundColor: "#55aacc")
                attributeState("25",  label:"25", backgroundColor: "#55aacc")
                attributeState("26",  label:"26", backgroundColor: "#55aacc")
                attributeState("27",  label:"27", backgroundColor: "#55aacc")
                attributeState("28",  label:"28", backgroundColor: "#55aacc")
                attributeState("29",  label:"29", backgroundColor: "#55aacc")
                attributeState("30",  label:"30", backgroundColor: "#55aacc")
                attributeState("31",  label:"31", backgroundColor: "#55aacc")
                attributeState("32",  label:"32", backgroundColor: "#55aacc")
                attributeState("33",  label:"33", backgroundColor: "#55aacc")
                attributeState("34",  label:"34", backgroundColor: "#55aacc")
                attributeState("35",  label:"35", backgroundColor: "#55aacc")
                attributeState("36",  label:"36", backgroundColor: "#55aacc")
                attributeState("37",  label:"37", backgroundColor: "#55aacc")
                attributeState("38",  label:"38", backgroundColor: "#55aacc")
                attributeState("39",  label:"39", backgroundColor: "#55aacc")
                attributeState("40",  label:"40", backgroundColor: "#55aacc")
                attributeState("41",  label:"41", backgroundColor: "#55aacc")
                attributeState("42",  label:"42", backgroundColor: "#55aacc")
                attributeState("43",  label:"43", backgroundColor: "#55aacc")
                attributeState("44",  label:"44", backgroundColor: "#55aacc")
                attributeState("45",  label:"45", backgroundColor: "#55aacc")
                attributeState("46",  label:"46", backgroundColor: "#55aacc")
                attributeState("47",  label:"47", backgroundColor: "#55aacc")
                attributeState("48",  label:"48", backgroundColor: "#55aacc")
                attributeState("49",  label:"49", backgroundColor: "#55aacc")
                attributeState("50",  label:"50", backgroundColor: "#55aacc")
                attributeState("51",  label:"51", backgroundColor: "#55aacc")
                attributeState("52",  label:"52", backgroundColor: "#55aacc")
                attributeState("53",  label:"53", backgroundColor: "#55aacc")
                attributeState("54",  label:"54", backgroundColor: "#55aacc")
                attributeState("55",  label:"55", backgroundColor: "#55aacc")
                attributeState("56",  label:"56", backgroundColor: "#55aacc")
                attributeState("57",  label:"57", backgroundColor: "#55aacc")
                attributeState("58",  label:"58", backgroundColor: "#55aacc")
                attributeState("59",  label:"59", backgroundColor: "#55aacc")
                attributeState("60",  label:"60", backgroundColor: "#55aacc")
                attributeState("61",  label:"61", backgroundColor: "#55aacc")
                attributeState("62",  label:"62", backgroundColor: "#55aacc")
                attributeState("63",  label:"63", backgroundColor: "#55aacc")
                attributeState("64",  label:"64", backgroundColor: "#55aacc")
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
		sendEvent (name: "switch", value: "active", display: true, displayed: true, isStateChange: true)
	}
	else if (cmd.substring(3,9).substring(0,3) == "610"){
		sendEvent (name: "switch", value: "inactive", display: true, displayed: true, isStateChange: true)
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