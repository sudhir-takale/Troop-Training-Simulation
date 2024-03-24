
# Problem Statement: (Troop training simulation is inspired from Clash of Clans games.)
As a gaming programmer you have to create a simulation software using which gamers can train army troops. Definition and details of the simulation is as follows
Army Troops:  
There are two kinds of troops Archers and Barbarians. Each trooper(archer/barbarian)
<br /><br />

| Trooper                       | Training Time (seconds) | Training Cost (magic potions) |
|:------------------------------|:-----------------------:|:-----------------------------:|
| Barbarian(weapon: sword)      |            3            |              10               |
| Archer(weapon: Bow and Arrow) |            6            |              20               |

### Barracks: where each trooper gets trained.
- Only one trooper can be trained at a given point of time.
- The maximum seat capacity of a barracks is 10.
- Others have to wait to outside the barracks
- Barracks can have mix of troopers: e.g.: 5 Archers and 5 Barbarians or 4 Archers and 6 Barbarians or 10 Archers or 10 Barbarians 
### Army Camp: where troops assemble after training.
## Scenario 1: Simulate the training and train barbarians and/or archers.
- As a gamer 
- i should be able to input no.of barbarians and/or archers i would like to train. 
- i should be able to see how many troops are trained and available in troop camp after training completes. Example input/output:
### troop-training > start-training
1. train troops.  
2. view troop camp
- What do you want to do ? 1 <br />
1. Archer
2. Barbarian <br /> 
which troop u want to train ? 1 <br />
how many archers you want to train ? 10 <br />
 training...<br />
- training complete. troops are available in the troop camp. <br />
1. train troops. <br />
2. view troop camp  <br />
- What do you want to do ? 2 <br />
- Archers: 10 <br />
- Barbarian: 0 <br />
1. train troops. <br />
2. view troop camp <br />
What do you want to do ? 1 <br />
  

---------------------------------------------------------------------------

ProjectName : Troop Training Simulator -
Domain: Training Simulation

## Gamer -> manager

### models :
Troop
  - time
  - cost

- Archers extends troop 
   - set values
  
- Barbarian
   - set values 

- enum Troopers 
    - ARCHERS
    - BARBARIANS

- TrainTrooper
  - Trooper
  - count
  
- Barracks 
     - capacity - 10
     - List<Troop> troopersWaitingForTraining

### domain services

- TrainService 
  - trainTheTrooper()
  - sendThemToArmyCamp()

- ArmyCamp -> display 
  - map<String, Integer> archers;
  - map<String, Integer> barbarian;

   - displayTrainedCountOfTroopers() 

### config
  - setBarracks limit



gamer -> trainTheTroopers,-> whom-> archers -> how many


game/manager
  - request to train trooper
  - which troopers 
  - count of troopers
      - perform data validation

Barracks ->
  - has waiting list of troopers
  - according train the trooper 

armyCamp 
  - display troops count
  - maintains map 

### GameManager
  - has access to 
      - request new troopers
      - view troops count

### Manager 
    - manages everything
        - create new archers
        - create barbarians
        - send To train them

### Business requirements
    - actual implementation



