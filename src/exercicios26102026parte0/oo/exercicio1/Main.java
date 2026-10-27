package exercicios26102026parte0.oo.exercicio1;

import java.util.Comparator;
import java.util.List;

class Main {

    static void main(String[] args) {

        // -------------------------------------------------------------------------------------------
    	
        var repository = new DeviceRepository();
        var deviceService = new DeviceService(repository);
        var automationService = new AutomationService();
        var energyService = new EnergyService();

        // -------------------------------------------------------------------------------------------
        
        var livingRoom = new Room(IdGenerator.nextId(), "Living Room");
        var bedroom = new Room(IdGenerator.nextId(), "Bedroom");
        var kitchen = new Room(IdGenerator.nextId(), "Kitchen");

        // -------------------------------------------------------------------------------------------        
        
        var livingLight = deviceService.register(
                new SmartLight(deviceService.nextId(), "Living Light", livingRoom));

        deviceService.register(
                new SmartLight(deviceService.nextId(), "Bedroom Light", bedroom));

        var thermostat = deviceService.register(
                new SmartThermostat(deviceService.nextId(), "Thermostat", livingRoom));

        deviceService.register(
                new SmartLock(deviceService.nextId(), "Front Door", livingRoom));

        var motionSensor = deviceService.register(
                new MotionSensor(deviceService.nextId(), "Motion Sensor", kitchen));

        var camera = deviceService.register(
                new SmartCamera(deviceService.nextId(), "Security Camera", livingRoom));

        var speaker = deviceService.register(
                new SmartSpeaker(deviceService.nextId(), "Smart Speaker", bedroom));

        var kitchenLight = deviceService.register(
                new SmartLight(deviceService.nextId(), "Kitchen Light", kitchen));

        // -------------------------------------------------------------------------------------------
        
        
        livingLight.setBrightness(80);
        thermostat.setTargetTemperature(21.5);
        speaker.setVolume(50);

        livingLight.turnOn();
        thermostat.turnOn();
        camera.turnOn();
        motionSensor.turnOn();

        motionSensor.detectMotion();
        
        // -------------------------------------------------------------------------------------------
        
        AutomationRule rule = new AutomationRule(
                "Turn on lights when motion is detected",
                device -> motionSensor.isMotionDetected()
                        && device instanceof SmartLight
                        && device.getRoom().equals(kitchen),
                SmartDevice::turnOn
        );

        // -------------------------------------------------------------------------------------------
                 
        automationService.execute(rule, deviceService.findAll());

        // -------------------------------------------------------------------------------------------        
        
        List<SmartDevice> devices = deviceService.findAll();

        // -------------------------------------------------------------------------------------------
                
        IO.println("SMART HOME SYSTEM");
        IO.println("Registered devices: " + devices.size());

        // -------------------------------------------------------------------------------------------
                
        IO.println("\nALL DEVICES");

        devices.stream()
                .sorted(Comparator.comparing(SmartDevice::getName))
                .forEach(IO::println);
        
        // -------------------------------------------------------------------------------------------
        
        IO.println("\nACTIVE DEVICES");

        devices.stream()
                .filter(SmartDevice::isOn)
                .forEach(device ->
                        IO.println(device.getName() + " | " + device.getRoom().name()));

        // -------------------------------------------------------------------------------------------
        
        IO.println("\nFUNCTIONAL INTERFACE");

        DevicePredicate activeDevice = SmartDevice::isOn;

        devices.stream()
                .filter(activeDevice::test)
                .map(SmartDevice::getName)
                .forEach(IO::println);

        IO.println("\nENERGY REPORT");
        IO.println("Active devices: "
                + energyService.countActiveDevices(devices));

        IO.println("Total power: "
                + energyService.totalPowerWatts(devices) + " W");

        IO.println("Estimated energy for 8 hours: "
                + energyService.estimatedEnergyKwh(devices, 8) + " kWh");

        IO.println("\nDEVICE LOOKUP");
        IO.println(deviceService.findById(livingLight.getId()));

        IO.println("\nAUTOMATION RESULT");
        IO.println(kitchenLight.getName() + " is "
                + kitchenLight.getStatus());

        // -------------------------------------------------------------------------------------------
    }
}