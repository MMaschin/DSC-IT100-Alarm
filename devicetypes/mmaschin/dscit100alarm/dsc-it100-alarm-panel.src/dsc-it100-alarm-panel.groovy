/**
 *  DSC-IT100-Alarm Panel
 *
 *  Author: Matt Maschinot
 *  
 *  Date: 04/10/2019
 */

// for the UI
metadata {
    definition(name: "DSC-IT100-Alarm-Panel", namespace: "mmaschin/DSCIT100Alarm", author: "mmaschin@gmail.com") {

        capability "Alarm"
        capability "Switch"
        capability "Refresh"
        capability "Polling"

        attribute "alarmStatus", "string"
        attribute "awaySwitch", "string"
        attribute "staySwitch", "string"
        attribute "panicSwitch", "string"
        attribute "memoryLed", "string"
        attribute "bypassLed", "string"
        attribute "troubleLed", "string"
        attribute "programLed", "string"
        attribute "acLed", "string"
        attribute "lcdDisplay", "string"

        command "armAway"
        command "armStay"
        command "disarm"
        command "clear"
        command "update"
        command "chimeToggle"
        command "panic"
        command "away"
        command "dscalarmparse"
        command "updatestatus"
        command "alarmsetdate"
        command "refreshPanel"
        command "key0Pressed"
        command "key1Pressed"
        command "key2Pressed"
        command "key3Pressed"
        command "key4Pressed"
        command "key5Pressed"
        command "key6Pressed"
        command "key7Pressed"
        command "key8Pressed"
        command "key9Pressed"
        command "keyStarPressed"
        command "keyPoundPressed"
        command "keyPrevPressed"
        command "keyNextPressed"

    }

    preferences {
        input "proxyAddress", "text", title: "Raspberry Pi address", description: "(ie. 192.168.1.10)", required: true
        input "proxyPort", "text", title: "Raspberry Pi Port", description: "(ie. 3000)", required: true, defaultValue: "3000"
        input name: "confirmation", type: "bool", title: "Confirmation", description: "Require Confirmation To Turn On Alarm?", required: true
        input "idelog", "bool", title: "Select True or False:", defaultValue: false, required: false
    }

    // UI tile definitions
    tiles(scale: 2) {

        standardTile("alarmStatus", "device.alarmStatus", width: 2, height: 2) {
            state "ready", label: 'Ready', icon: "st.Home.home2", backgroundColor: "#ffffff"
            state "disarmed", label: 'Ready', icon: "st.Home.home2", backgroundColor: "#ffffff"
            state "notready", label: 'Not Ready', icon: "st.Home.home2", backgroundColor: "#ffaa11"
            state "away", label: 'Away', action: "disarm", icon: "st.Home.home3", backgroundColor: "#aaddee"
            state "stay", label: 'Stay', action: "disarm", icon: "st.Home.home4", backgroundColor: "#ffff99"
            state "arming", label: 'Arming', action: "disarm", icon: "st.Home.home2", backgroundColor: "#B8B8B8"
            state "alarm", label: 'Alarm', action: "clear", icon: "st.Home.home2", backgroundColor: "#ff0000"
        }
        
        standardTile("away", "device.awaySwitch") {
            state "on", label: "Away", action: "armAway", icon: "st.Home.home3", backgroundColor: "#aaddee"
            state "off", label: "Away", icon: "st.Home.home3", backgroundColor: "#ffffff"
            state "confirm", label: "Away", action: "armAway", icon: "st.alarm.alarm.alarm", backgroundColor: "#ffaa11"
        }
        
        standardTile("stay", "device.staySwitch") {
            state "on", label: "Stay", action: "armStay", icon: "st.Home.home4", backgroundColor: "#ffff99"
            state "off", label: "Stay", icon: "st.Home.home4", backgroundColor: "#ffffff"
            state "confirm", label: "Stay", action: "armStay", icon: "st.alarm.alarm.alarm", backgroundColor: "#ffaa11"
        }
        
        standardTile("blank", "blank") {}
        
        standardTile("panic", "device.panicSwitch") {
            state "on", label: "Panic", action: "panic", icon: "st.alarm.alarm.alarm", backgroundColor: "#ff5050"
            state "off", label: "Panic", action: "disarm", icon: "st.alarm.alarm.alarm", backgroundColor: "#ffffff"
            state "confirm", label: "Panic", action: "panic", icon: "st.alarm.alarm.alarm", backgroundColor: "#ffaa11"
        }

        standardTile("alarmsetdate", "device.alarmsetdate", decoration: "flat") {
            state "alarmsetdate", label: 'Date/Time', action: "alarmsetdate", icon: "st.Office.office6"
        }

		valueTile("lcdDisplay", "device.lcdDisplay", width: 3, height: 1, decoration: "flat") {
            state "default", label: '${currentValue}'
        }

        standardTile("refreshPanel", "device.refreshPanel", decoration: "flat") {
            state "refreshPanel", label: 'Refresh', action: "refreshPanel", icon: "st.secondary.refresh"
        }
        
        valueTile("keyPrev", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '<', action: "keyPrevPressed", backgroundColor: "#B8B8B8"
        }
        
        valueTile("keyNext", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '>', action: "keyNextPressed", backgroundColor: "#B8B8B8"
        }
        
        valueTile("key1", "blank", decoration: "flat") {
            state "default", label: '1', action: "key1Pressed", backgroundColor: "#B8B8B8"
        }
        
        valueTile("key2", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '2', action: "key2Pressed", backgroundColor: "#B8B8B8"
        }
        
        valueTile("key3", "blank", decoration: "flat") {
            state "default", label: '3', action: "key3Pressed", backgroundColor: "#B8B8B8"
        }

        standardTile("memory", "device.memoryLed", decoration: "flat") {
            state "on", label: "Memory", backgroundColor: "#ffdd44"
            state "off", label: "Memory", backgroundColor: "#ffffff", defaultState: true
        }
        
        standardTile("chime", "device.chime", decoration: "flat") {
            //                      state "chimeOff", label:'Chime', action:'chimeToggle', icon:"st.secondary.beep", backgroundColor: "#ffffff"
            //                      state "chimeOn", label:'Chime', action:'chimeToggle', icon:"st.secondary.beep", backgroundColor: "#66dd44"   //green
            state "chimeOff", label: 'Chime', action: 'chimeToggle', backgroundColor: "#ffffff"
            state "chimeOn", label: 'Chime', action: 'chimeToggle', backgroundColor: "#ffdd44" //green
        }
        
        standardTile("blank", "blank") {}
        
        valueTile("key4", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '4', action: "key4Pressed", backgroundColor: "#B8B8B8"
        }
        
        valueTile("key5", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '5', action: "key5Pressed", backgroundColor: "#B8B8B8"
        }
        
        valueTile("key6", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '6', action: "key6Pressed", backgroundColor: "#B8B8B8"
        }

        standardTile("trouble", "device.troubleLed", decoration: "flat") {
            state "on", label: "Trouble", backgroundColor: "#ffdd44"
            state "off", label: "Trouble", backgroundColor: "#ffffff", defaultState: true
        }
        
        standardTile("bypass", "device.bypassLed", decoration: "flat") {
            state "on", label: "Bypass", backgroundColor: "#ffdd44"
            state "off", label: "Bypass", backgroundColor: "#ffffff", defaultState: true
        }
        
        standardTile("blank", "blank") {}
        
        valueTile("key7", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '7', action: "key7Pressed", backgroundColor: "#B8B8B8"
        }
        
        valueTile("key8", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '8', action: "key8Pressed", backgroundColor: "#B8B8B8"
        }
        
        valueTile("key9", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '9', action: "key9Pressed", backgroundColor: "#B8B8B8"
        }

        standardTile("ac", "device.acLed", decoration: "flat") {
            state "on", label: "Power", backgroundColor: "#ffdd44"
            state "off", label: "Power", backgroundColor: "#ffffff", defaultState: true
        }
        
        standardTile("program", "device.programLed", decoration: "flat") {
            state "on", label: "Program", backgroundColor: "#ffdd44"
            state "off", label: "Program", backgroundColor: "#ffffff", defaultState: true
        }
        
        standardTile("blank", "blank") {}
        
        valueTile("key*", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '*', action: "keyStarPressed", backgroundColor: "#B8B8B8"
        }
        
        valueTile("key0", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '0', action: "key0Pressed", backgroundColor: "#B8B8B8"
        }
        
        valueTile("key#", "blank", width: 1, height: 1, decoration: "flat") {
            state "default", label: '#', action: "keyPoundPressed", backgroundColor: "#B8B8B8"
        }

        childDeviceTiles("openzones", height: 1, width: 1)

        main(["alarmStatus"])

        details(["alarmStatus", "away", "stay", "blank", "panic", "alarmsetdate", "lcdDisplay", "refreshPanel", "keyPrev", "keyNext", "key1", "key2", "key3", "memory", "chime", "blank", "key4", "key5", "key6", "trouble", "bypass", "blank", "key7", "key8", "key9", "ac", "program", "blank", "key*", "key0", "key#", "openzones"])

    }
}


def key0Pressed() {
    sendRaspberryKeyPressed("0")
}
def key1Pressed() {
    sendRaspberryKeyPressed("1")
}
def key2Pressed() {
    sendRaspberryKeyPressed("2")
}
def key3Pressed() {
    sendRaspberryKeyPressed("3")
}
def key4Pressed() {
    sendRaspberryKeyPressed("4")
}
def key5Pressed() {
    sendRaspberryKeyPressed("5")
}
def key6Pressed() {
    sendRaspberryKeyPressed("6")
}
def key7Pressed() {
    sendRaspberryKeyPressed("7")
}
def key8Pressed() {
    sendRaspberryKeyPressed("8")
}
def key9Pressed() {
    sendRaspberryKeyPressed("9")
}
def keyStarPressed() {
    sendRaspberryKeyPressed("*")
}
def keyPoundPressed() {
    sendRaspberryKeyPressed("#")
}
def keyPrevPressed() {
    sendRaspberryKeyPressed("<")
}
def keyNextPressed() {
    sendRaspberryKeyPressed(">")
}


//add 12 zone devices to display open zones.  These are the same types as 
//those created for the app, but they will be updated to show what zones are
//currently open.
def addChildDevices() {

    def children
    children = getChildDevices()
    
    if (children.size() < 12) {
    
        for ( int i=0; i < 12; i++) {     

            def zonePanelNetworkID = "Open_Zone${i}"
            def panelZoneDevice
            def childExists = false
            try {
                children = getChildDevices()
                children.each {
                    child->
                    if (!childExists && child.deviceNetworkId) {
                        childExists = child.deviceNetworkId == zonePanelNetworkID
                    }
                }

            } catch (e) {}

            try {
                if (!childExists) {
                    panelZoneDevice = addChildDevice("mmaschin/DSCIT100Alarm", "DSC-IT100-Alarm-Type-Contact", zonePanelNetworkID, device.getHub().getId(), [componentName: "${zonePanelNetworkID}", componentLabel: "${i}", label: "Panel_Open_Zone${i}", isComponent: true, completedSetup: true])
                    panelZoneDevice.sendEvent(name: "switch", value: "0", display: true, displayed: true, isStateChange: true)
                }
            } catch (e) {
                log.debug "*** CAUGHT EXCEPTION  (A) - ${e}"
            }
        }

 		def openZones = new ArrayList()
        state.openZoneNumners = openZones
	}
}


//Process commands from the Smart App.  These will be responses the Smart App has received from the REST API
def dscalarmparse(String description) {

	writeLog("dscalarmparse - description=${description}")

    def msg = description

    if (msg.length() >= 4) {
        if (msg.substring(0, 2) == "RD") {
            if (msg[3] == "0") {
                sendEvent(name: "alarmStatus", value: "notready")
                sendEvent(name: "awaySwitch", value: "off")
                sendEvent(name: "staySwitch", value: "off")
                sendEvent(name: "panicSwitch", value: "on")
            } else {
                sendEvent(name: "alarmStatus", value: "ready")
                sendEvent(name: "awaySwitch", value: "on")
                sendEvent(name: "staySwitch", value: "on")
                sendEvent(name: "panicSwitch", value: "on")

            }
        // Process arm update
        } else if (msg.substring(0, 2) == "AR") {
            if (msg[3] == "0") {
                sendEvent(name: "alarmStatus", value: "disarmed")
                sendEvent(name: "awaySwitch", value: "off")
                sendEvent(name: "staySwitch", value: "off")
                sendEvent(name: "panicSwitch", value: "on")
            } else if (msg[3] == "1") {
                if (msg[5] == "0") {
                    sendEvent(name: "alarmStatus", value: "away")
                    sendEvent(name: "awaySwitch", value: "off")
                    sendEvent(name: "staySwitch", value: "off")
                    sendEvent(name: "panicSwitch", value: "on")
                } else if (msg[5] == "2") {
                    sendEvent(name: "alarmStatus", value: "stay")
                    sendEvent(name: "awaySwitch", value: "off")
                    sendEvent(name: "staySwitch", value: "off")
                    sendEvent(name: "panicSwitch", value: "on")
                }
            } else if (msg[3] == "2") {
                sendEvent(name: "alarmStatus", value: "arming")
                sendEvent(name: "awaySwitch", value: "off")
                sendEvent(name: "staySwitch", value: "off")
                sendEvent(name: "panicSwitch", value: "on")
            }
        } else if (msg.substring(0, 2) == "SY") {
            if (msg.substring(3, 6) == "901") {

                def i1 = msg.toLowerCase().indexOf("time");
                def i2 = msg.toLowerCase().indexOf("<>");
                def i3 = msg.toLowerCase().indexOf("   ");
                if (i1 > -1) {
                
                	poll()
                
        			addChildDevices()  //check to make sure the openzone child devices are ok        	
        
                    sendEvent(name: "lcdDisplay", value: msg.substring(11, i1 + 4) + "\n \r" + msg.substring(i1 + 4), display: false, displayed: false)
                } else if (i2 > -1) {
                    sendEvent(name: "lcdDisplay", value: msg.substring(11, i2 + 2) + "\n \r" + msg.substring(i2 + 2), display: false, displayed: false)
                } else if (i3 > -1) {
                    sendEvent(name: "lcdDisplay", value: msg.substring(11, i3 + 3) + "\n \r" + msg.substring(i3 + 3), display: false, displayed: false)
                } else {
                    sendEvent(name: "lcdDisplay", value: msg.substring(11, msg.length()), display: false, displayed: false)
                }
            } else if (msg.substring(3, 6) == "903") {
                if (msg[6] == "3") {
                    if (msg[7] == "0") {
                        sendEvent(name: "memoryLed", value: "off")
                    } else {
                        sendEvent(name: "memoryLed", value: "on")
                    }
                }
                if (msg[6] == "4") {
                    if (msg[7] == "0") {
                        sendEvent(name: "bypassLed", value: "off")
                    } else {
                        sendEvent(name: "bypassLed", value: "on")
                    }
                } else if (msg[6] == "5") {
                    if (msg[7] == "0") {
                        sendEvent(name: "troubleLed", value: "off")
                    } else {
                        sendEvent(name: "troubleLed", value: "on")
                    }
                } else if (msg[6] == "6") {
                    if (msg[7] == "0") {
                        sendEvent(name: "programLed", value: "off")
                    } else {
                        sendEvent(name: "programLed", value: "on")
                    }
                } else if (msg[6] == "9") {
                    if (msg[7] == "0") {
                        sendEvent(name: "acLed", value: "off")
                    } else {
                        sendEvent(name: "acLed", value: "on")
                    }
                }
            }
        // Process alarm update
        } else if (msg.substring(0, 2) == "AL") {
            if (msg[3] == "1") {
                sendEvent(name: "alarmStatus", value: "alarm")
            }
        // Process chime update
        } else if (msg.substring(0, 2) == "CH") {
            if (msg[3] == "1") {
                sendEvent(name: "chime", value: "chimeOn")
            } else {
                sendEvent(name: "chime", value: "chimeOff")
            }
        // Process zone update
        } else if (msg.substring(0, 2) == "ZN") {

			//the following code will update the child device handlers to 
            //reflect which zones are currently open

			def openZones = state.openZoneNumners 
			if (openZones != null) {

                def zoneNumber = msg.substring(6, 9)
                zoneNumber = zoneNumber.replaceAll("^0+", "");

                try {
                    if (msg.substring(3, 6) == "609") {

                        if (!openZones.contains(zoneNumber)) {
                            openZones.add(zoneNumber)
                        }
                        
                    } else if (msg.substring(3, 6) == "610") {
                        openZones.remove(zoneNumber)
                    }
                    
                } catch (e) {
                    log.debug "*** CAUGHT EXCEPTION (1) - ${e}"
                }

				Collections.sort(openZones)

                for (int i=0; i < 12; i++) { 
                    def zonePanelNetworkID = "Open_Zone${i}"
                    def childExists = false
                    def children
                    try {
                        children = getChildDevices()
                        children.each {
                            child->
                                if (!childExists && child.deviceNetworkId) {
                                    childExists = child.deviceNetworkId == zonePanelNetworkID
                                    if (childExists) {
                                    	if (i < openZones.size()) {
	                                        child.sendEvent(name: "switch", value: "${openZones.get(i)}", display: true, displayed: true, isStateChange: true)
                                    	} else {
	                                    	child.sendEvent(name: "switch", value: "0", display: true, displayed: true, isStateChange: true)
                                        }
                                    }
                                }
                        }
                    } catch (e) {
                        log.debug "*** CAUGHT EXCEPTION (3) - ${e}"
                    }
                }

                state.openZoneNumners = openZones
            }
        }
    }
}


// Implement "switch" (turn alarm on/off)
def on() {
    armAway()
}

def off() {
    disarm()
}

def away() {
    armAway()
}

def strobe() {
    panic()
}

def siren() {
    panic()
}

def both() {
    panic()
}

// Commands sent to Raspberry Pi
def armAway() {
    writeLog("DSCAlarmSmartAppV2 AlarmPanel Device Type - Sending armAway command")

    def awaySwitchState = device.currentState("awaySwitch")?.value

    if (awaySwitchState == "confirm" || !settings.confirmation) {
        sendRaspberryCommand("alarmArmAway")
        //       sendEvent(name: "awaySwitch", value: "off", display: true, displayed: true, isStateChange: true)
    } else {

        sendEvent(name: "awaySwitch", value: "confirm", display: true, displayed: true, isStateChange: true)
        runIn(3, cancelConfirm, [data: [switchName: "awaySwitch"]])
    }
}

def armStay() {
    writeLog("DSCAlarmSmartAppV2 AlarmPanel Device Type - Sending armStay command")

    def staySwitchState = device.currentState("staySwitch")?.value

    if (staySwitchState == "confirm" || !settings.confirmation) {
        sendRaspberryCommand("alarmArmStay")
        //       sendEvent(name: "staySwitch", value: "off", display: true, displayed: true, isStateChange: true)
    } else {

        sendEvent(name: "staySwitch", value: "confirm", display: true, displayed: true, isStateChange: true)
        runIn(3, cancelConfirm, [data: [switchName: "staySwitch"]])
    }
}

def disarm() {
    writeLog("DSCAlarmSmartAppV2 AlarmPanel Device Type - Sending disarm command")
    sendRaspberryCommand("alarmDisarm")
}

def chimeToggle() {
    writeLog("DSCAlarmSmartAppV2 AlarmPanel Device Type - Sending Toggling chime")
    sendRaspberryCommand("alarmChimeToggle")
}

def panic() {
    writeLog("DSCAlarmSmartAppV2 AlarmPanel Device Type - Sending panic command")

    def panicSwitchState = device.currentState("panicSwitch")?.value

    if (panicSwitchState == "confirm" || !settings.confirmation) {
        //    sendRaspberryCommand("alarmPanic")
        sendEvent(name: "panicSwitch", value: "off", display: true, displayed: true, isStateChange: true)
    } else {
        sendEvent(name: "panicSwitch", value: "confirm", display: true, displayed: true, isStateChange: true)
        runIn(3, cancelConfirm, [data: [switchName: "panicSwitch"]])
    }
}

def cancelConfirm(data) {

    def switchState = device.currentState(data.switchName)?.value
    if (switchState == "confirm") {
        sendEvent(name: data.switchName, value: "on", display: true, displayed: true, isStateChange: true)
    }
}

def alarmsetdate() {
    writeLog("DSCAlarm AlarmDeviceType - Sending alarmSetDate command")
    sendRaspberryCommand("alarmsetdate")
}

def refreshPanel() {
    writeLog("DSCAlarm refreshPanel - Sending refreshPanel command")
    sendCommand('/api/alarmUpdate')
}

// TODO: Need to send off, on, off with a few secs in between to stop and clear the alarm
def clear() {
    disarm()
}

def sendRaspberryCommand(String command) {
    def path = "/api/$command"
    sendCommand(path)
}

def sendRaspberryKeyPressed(String key) {
    if (key == "#") { //# key caused issues the code in the Raspberry pi will convert the L back and send a # to the DSC panel
        key = "L"
    }

    def path = "/api/sendKeyPress/" + key
    sendCommand(path)
}

def refresh() {
    writeLog("Executing 'refresh' which is actually poll()")
    // TODO: handle 'refresh' command
}

def poll() {
    refresh()
}

def writeLog(message) {
    if (idelog) {
        log.debug "${message}"
    }
}

//Send command to Smartthings hub
//
def sendCommand(path) {

    if (settings.proxyAddress.length() == 0 ||
        settings.proxyPort.length() == 0) {
        log.error "SmartThings Node Proxy configuration not set!"
        return
    }

    def host = settings.proxyAddress + ":" + settings.proxyPort
    def headers = [: ]
    headers.put("HOST", host)
    headers.put("Content-Type", "application/json")
    headers.put("stnp-auth", settings.authCode)

    def hubAction = new physicalgraph.device.HubAction(
        method: "GET",
        path: path,
        headers: headers
    )

    sendHubCommand(hubAction)
}