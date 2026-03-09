<p>The driver's license numbers in the states of Wisconsin and Florida are generated based on a person's name, date of birth, and gender. You will create an application that gathers the user's demographic data and generates their drivers license number for both states.</p>
<p>The states use the following formats.</p>
<ul>
    <li>Wisconsin: SSSS-FFFY-YDDD-NN</li>
    <li>Florida: SSSS-FFF-YY-DDD-N</li>
</ul>
<p>The components are determined as follows.</p>
<ul>
    <li>SSSS: The last name encoded using the Soundex algorithm</li>
    <li>FFF: The sum of the first name and middle initial codes (see below)</li>
    <li>YY: The two-digit year of birth</li>
    <li>DDD: The month and day of birth, plus a gender offset. The base formula is (month - 1) * 40 + day. If the person is male, add 0. If female, add 500.</li>
    <li>NN: Overflow digits used to distinguish two people who have the same driver's license number. <strong>For this application, always use 0 or 00.</strong></li>
</ul>
<p>&nbsp;</p>
<h3>Requirements</h3>
<p><span>Accept and clone the <span style="font-size: 12pt;">assignment</span> from GitHub Classroom using the following link:&nbsp;</span></p>
<p>Create the following classes.</p>
<h3>DriversLicense</h3>
<p>Fields</p>
<table style="border-collapse: collapse; width: 59.3987%;" border="1">
    <tbody>
        <tr>
            <td style="width: 33.2695%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 33.3333%; text-align: center;"><strong>Data Type</strong></td>
            <td style="width: 33.3333%; text-align: center;"><strong>Name</strong></td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 33.3333%;">String</td>
            <td style="width: 33.3333%;">SSSS (or soundexCode)</td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 33.3333%;">int</td>
            <td style="width: 33.3333%;">FFF (or firstNameMiddleInitial)</td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 33.3333%;">int</td>
            <td style="width: 33.3333%;">YY (or birthYear)</td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 33.3333%;">int</td>
            <td style="width: 33.3333%;">DDD (or birthMonthDayGender)</td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 33.3333%;">int</td>
            <td style="width: 33.3333%;">NN (or overflow)</td>
        </tr>
    </tbody>
</table>
<p>Methods: Include getters and setters for all fields.</p>
<p>&nbsp;</p>
<h3>InvalidBirthdayException (subclass of Exception)</h3>
<p>Methods</p>
<table style="border-collapse: collapse; width: 98.6146%;" border="1">
    <tbody>
        <tr>
            <td style="width: 12.9076%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 12.819%; text-align: center;"><strong>Return Type</strong></td>
            <td style="width: 19.4562%; text-align: center;"><strong>Name</strong></td>
            <td style="width: 12.7307%; text-align: center;"><strong>Parameters</strong></td>
            <td style="width: 25.7458%; text-align: center;"><strong>Purpose</strong></td>
        </tr>
        <tr>
            <td style="width: 12.9076%;">public</td>
            <td style="width: 12.819%;">--</td>
            <td style="width: 19.4562%;">InvalidBirthdayException</td>
            <td style="width: 12.7307%;">int year,<br />int month,<br />int day</td>
            <td style="width: 25.7458%;">Constructor that calls the superclass constructor with a message that the given year, month, and day are invalid.</td>
        </tr>
    </tbody>
</table>
<p>&nbsp;</p>
<h3>MissingNameException (subclass of Exception)</h3>
<p>Methods</p>
<table style="border-collapse: collapse; width: 98.6146%;" border="1">
    <tbody>
        <tr>
            <td style="width: 12.9076%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 12.819%; text-align: center;"><strong>Return Type</strong></td>
            <td style="width: 19.4562%; text-align: center;"><strong>Name</strong></td>
            <td style="width: 12.7307%; text-align: center;"><strong>Parameters</strong></td>
            <td style="width: 25.7458%; text-align: center;"><strong>Purpose</strong></td>
        </tr>
        <tr>
            <td style="width: 12.9076%;">public</td>
            <td style="width: 12.819%;">--</td>
            <td style="width: 19.4562%;">MissingNameException</td>
            <td style="width: 12.7307%;">String nameType</td>
            <td style="width: 25.7458%;">Constructor that calls the superclass constructor with a message that the name type (e.g. "first name") may not be blank.</td>
        </tr>
    </tbody>
</table>
<p>&nbsp;</p>
<h3>UnknownGenderCodeException (subclass of Exception)</h3>
<p>Methods</p>
<table style="border-collapse: collapse; width: 98.6146%;" border="1">
    <tbody>
        <tr>
            <td style="width: 12.9076%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 12.819%; text-align: center;"><strong>Return Type</strong></td>
            <td style="width: 19.4562%; text-align: center;"><strong>Name</strong></td>
            <td style="width: 12.7307%; text-align: center;"><strong>Parameters</strong></td>
            <td style="width: 25.7458%; text-align: center;"><strong>Purpose</strong></td>
        </tr>
        <tr>
            <td style="width: 12.9076%;">public</td>
            <td style="width: 12.819%;">--</td>
            <td style="width: 19.4562%;">UnknownGenderCodeException</td>
            <td style="width: 12.7307%;">char genderCode</td>
            <td style="width: 25.7458%;">Constructor that calls the superclass constructor with a message that the given gender code is not known.</td>
        </tr>
    </tbody>
</table>
<p>&nbsp;</p>
<h3>FirstNameUtility</h3>
<p>Fields</p>
<table style="border-collapse: collapse; width: 59.3987%;" border="1">
    <tbody>
        <tr>
            <td style="width: 33.2695%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 33.3333%; text-align: center;"><strong>Data Type</strong></td>
            <td style="width: 33.3333%; text-align: center;"><strong>Name</strong></td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 33.3333%;">Map&lt;String, Integer&gt;</td>
            <td style="width: 33.3333%;">firstNameCodeMap</td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 33.3333%;">Map&lt;String, Integer&gt;</td>
            <td style="width: 33.3333%;">firstInitialCodeMap</td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 33.3333%;">Map&lt;String, Integer&gt;</td>
            <td style="width: 33.3333%;">middleInitialCodeMap</td>
        </tr>
    </tbody>
</table>
<p>Methods</p>
<table style="border-collapse: collapse; width: 98.6146%;" border="1">
    <tbody>
        <tr>
            <td style="width: 12.9076%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 12.819%; text-align: center;"><strong>Return Type</strong></td>
            <td style="width: 19.4562%; text-align: center;"><strong>Name</strong></td>
            <td style="width: 12.7307%; text-align: center;"><strong>Parameters</strong></td>
            <td style="width: 16.2767%; text-align: center;"><strong>Throws</strong></td>
            <td style="width: 25.7458%; text-align: center;"><strong>Purpose</strong></td>
        </tr>
        <tr>
            <td style="width: 12.9076%;">public</td>
            <td style="width: 12.819%;">--</td>
            <td style="width: 19.4562%;">FirstNameUtility</td>
            <td style="width: 12.7307%;">--</td>
            <td style="width: 16.2767%;"></td>
            <td style="width: 25.7458%;">Constructor that initializes the three maps with <a id="1837072" class="instructure_file_link instructure_scribd_file" href="https://wctc.instructure.com/courses/23525/files/1837072?wrap=1" target="_blank" rel="noopener" data-canvas-previewable="true" data-api-endpoint="https://wctc.instructure.com/api/v1/courses/23525/files/1837072" data-api-returntype="File">this data</a>.</td>
        </tr>
        <tr>
            <td style="width: 12.9076%;">public</td>
            <td style="width: 12.819%;">int</td>
            <td style="width: 19.4562%;">encodeFirstName</td>
            <td style="width: 12.7307%;">
                <p>String firstName,<br />String middleInitial</p>
            </td>
            <td style="width: 16.2767%;">MissingNameException</td>
            <td style="width: 25.7458%;"><span>If the first name is blank, throws a MissingNameException. If the first name appears in the first name map, returns the sum of the codes for the first name and middle initial. If not, it returns the sum of the codes for the first initial and middle initial. If a person has no middle initial, return only the first name or first initial code.</span></td>
        </tr>
    </tbody>
</table>
<p>&nbsp;</p>
<h3>LastNameUtility</h3>
<p>Fields</p>
<table style="border-collapse: collapse; width: 59.3987%;" border="1">
    <tbody>
        <tr>
            <td style="width: 33.2695%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 33.3333%; text-align: center;"><strong>Data Type</strong></td>
            <td style="width: 33.3333%; text-align: center;"><strong>Name</strong></td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 33.3333%;">Soundex</td>
            <td style="width: 33.3333%;">soundex</td>
        </tr>
    </tbody>
</table>
<p>Methods</p>
<table style="border-collapse: collapse; width: 98.6146%;" border="1">
    <tbody>
        <tr>
            <td style="width: 12.9076%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 12.819%; text-align: center;"><strong>Return Type</strong></td>
            <td style="width: 19.4562%; text-align: center;"><strong>Name</strong></td>
            <td style="width: 12.7307%; text-align: center;"><strong>Parameters</strong></td>
            <td style="width: 16.2767%; text-align: center;"><strong>Throws</strong></td>
            <td style="width: 25.7458%; text-align: center;"><strong>Purpose</strong></td>
        </tr>
        <tr>
            <td style="width: 12.9076%;">public</td>
            <td style="width: 12.819%;">String</td>
            <td style="width: 19.4562%;">encodeLastName</td>
            <td style="width: 12.7307%;">
                <p>String lastName</p>
            </td>
            <td style="width: 16.2767%;">MissingNameException</td>
            <td style="width: 25.7458%;"><span>If the last name is blank, throws a MissingNameException. Returns the encoding of the last name generated by the Soundex algorithm.&nbsp;</span></td>
        </tr>
    </tbody>
</table>
<p>&nbsp;</p>
<h3>MonthDayGenderUtility</h3>
<p>Fields</p>
<table style="border-collapse: collapse; width: 66.4485%;" border="1">
    <tbody>
        <tr>
            <td style="width: 33.2695%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 16.6667%; text-align: center;"><strong>Modifiers</strong></td>
            <td style="width: 16.6667%; text-align: center;"><strong>Data Type</strong></td>
            <td style="width: 16.6667%; text-align: center;"><strong>Name</strong></td>
            <td style="width: 16.6667%; text-align: center;"><strong>Value</strong></td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 16.6667%;">final</td>
            <td style="width: 16.6667%;">int</td>
            <td style="width: 16.6667%;">MOD_MALE</td>
            <td style="width: 16.6667%;">0</td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 16.6667%;">final</td>
            <td style="width: 16.6667%;">int</td>
            <td style="width: 16.6667%;">MOD_FEMALE</td>
            <td style="width: 16.6667%;">500</td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 16.6667%;">final</td>
            <td style="width: 16.6667%;">char</td>
            <td style="width: 16.6667%;">CODE_MALE</td>
            <td style="width: 16.6667%;">'M'</td>
        </tr>
        <tr>
            <td style="width: 33.2695%;">private</td>
            <td style="width: 16.6667%;">final</td>
            <td style="width: 16.6667%;">char</td>
            <td style="width: 16.6667%;">CODE_FEMALE</td>
            <td style="width: 16.6667%;">'F'</td>
        </tr>
    </tbody>
</table>
<p>Methods</p>
<table style="border-collapse: collapse; width: 98.6146%;" border="1">
    <tbody>
        <tr>
            <td style="width: 12.9076%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 12.819%; text-align: center;"><strong>Return Type</strong></td>
            <td style="width: 19.4562%; text-align: center;"><strong>Name</strong></td>
            <td style="width: 12.7307%; text-align: center;"><strong>Parameters</strong></td>
            <td style="width: 16.2767%; text-align: center;"><strong>Throws</strong></td>
            <td style="width: 25.7458%; text-align: center;"><strong>Purpose</strong></td>
        </tr>
        <tr>
            <td style="width: 12.9076%;">public</td>
            <td style="width: 12.819%;">int</td>
            <td style="width: 19.4562%;">encodeMonthDayGender</td>
            <td style="width: 12.7307%;">
                <p>int year,<br />int month,<br />int day,<br />char genderCode</p>
            </td>
            <td style="width: 16.2767%;">
                <p>UnknownGenderCodeException</p>
                <p>InvalidBirthdayException</p>
            </td>
            <td style="width: 25.7458%;">
                <p><span>If the gender code does not match one of the constants, an UnknownGenderCodeException is thrown. If the year, month, and day of birth do not constitute a valid date (such as February 31st or December 47th), an InvalidBirthdayException is thrown.</span></p>
                <p><span>Returns (month - 1) * 40 + day +&nbsp;<em>genderModConstant</em>.</span></p>
            </td>
        </tr>
    </tbody>
</table>
<p>&nbsp;</p>
<h3>DriversLicenseFormatter (interface)</h3>
<p>Methods</p>
<table style="border-collapse: collapse; width: 98.6146%;" border="1">
    <tbody>
        <tr>
            <td style="width: 12.819%; text-align: center;"><strong>Return Type</strong></td>
            <td style="width: 19.4562%; text-align: center;"><strong>Name</strong></td>
            <td style="width: 12.7307%; text-align: center;"><strong>Parameters</strong></td>
        </tr>
        <tr>
            <td style="width: 12.819%;">String</td>
            <td style="width: 19.4562%;">formatLicenseNumber</td>
            <td style="width: 12.7307%;">DriversLicense driversLicense</td>
        </tr>
    </tbody>
</table>
<p>&nbsp;</p>
<h3>FloridaFormatter (subclass of DriversLicenseFormatter)</h3>
<p>Methods</p>
<table style="border-collapse: collapse; width: 98.6146%;" border="1">
    <tbody>
        <tr>
            <td style="width: 12.9076%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 12.819%; text-align: center;"><strong>Return Type</strong></td>
            <td style="width: 19.4562%; text-align: center;"><strong>Name</strong></td>
            <td style="width: 12.7307%; text-align: center;"><strong>Parameters</strong></td>
            <td style="width: 25.7458%; text-align: center;"><strong>Purpose</strong></td>
        </tr>
        <tr>
            <td style="width: 12.9076%;">public</td>
            <td style="width: 12.819%;">String</td>
            <td style="width: 19.4562%;">formatLicenseNumber</td>
            <td style="width: 12.7307%;">DriversLicense driversLicense</td>
            <td style="width: 25.7458%;">Uses the getter methods of the driver's license object to retrieve the components of the license number. Returns them in a String in the format of SSSS-FFF-YY-DDD-N</td>
        </tr>
    </tbody>
</table>
<p>&nbsp;</p>
<h3>WisconsinFormatter (subclass of DriversLicenseFormatter)</h3>
<p>Methods</p>
<table style="border-collapse: collapse; width: 98.6146%;" border="1">
    <tbody>
        <tr>
            <td style="width: 12.9076%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 12.819%; text-align: center;"><strong>Return Type</strong></td>
            <td style="width: 19.4562%; text-align: center;"><strong>Name</strong></td>
            <td style="width: 12.7307%; text-align: center;"><strong>Parameters</strong></td>
            <td style="width: 25.7458%; text-align: center;"><strong>Purpose</strong></td>
        </tr>
        <tr>
            <td style="width: 12.9076%;">public</td>
            <td style="width: 12.819%;">String</td>
            <td style="width: 19.4562%;">formatLicenseNumber</td>
            <td style="width: 12.7307%;">DriversLicense driversLicense</td>
            <td style="width: 25.7458%;">Uses the getter methods of the driver's license object to retrieve the components of the license number. Returns them in a String in the format of SSSS-FFFY-YDDD-NN</td>
        </tr>
    </tbody>
</table>
<p>&nbsp;</p>
<h3>Main</h3>
<p><span style="font-family: inherit; font-size: 1rem;"><span>Once you have your other classes built, feel free to use the provided <a class="instructure_file_link instructure_scribd_file inline_disabled" title="Main.java" href="https://wctc.instructure.com/courses/23525/files/5213502?wrap=1" target="_blank" rel="noopener" data-canvas-previewable="false" data-api-endpoint="https://wctc.instructure.com/api/v1/courses/23525/files/5213502" data-api-returntype="File">Main.java</a> </span><span>file.</span></span></p>
<p><span style="font-family: inherit; font-size: 1rem;">Methods </span></p>
<table style="border-collapse: collapse; width: 98.6146%;" border="1">
    <tbody>
        <tr>
            <td style="width: 12.1111%; text-align: center;"><strong>Access Specifier</strong></td>
            <td style="width: 9.02014%; text-align: center;"><strong>Modifier</strong></td>
            <td style="width: 10.4361%; text-align: center;"><strong>Return Type</strong></td>
            <td style="width: 10.1642%; text-align: center;"><strong>Name</strong></td>
            <td style="width: 11.9341%; text-align: center;"><strong>Parameters</strong></td>
            <td style="width: 46.2704%; text-align: center;"><strong>Purpose</strong></td>
        </tr>
        <tr>
            <td style="width: 12.1111%;">public</td>
            <td style="width: 9.02014%;">static</td>
            <td style="width: 10.4361%;">void</td>
            <td style="width: 10.1642%;">main</td>
            <td style="width: 11.9341%;">String[] args</td>
            <td style="width: 46.2704%;">
                <p>Prompts the user for</p>
                <ul>
                    <li>first name</li>
                    <li>middle initial</li>
                    <li>last name</li>
                    <li>year, month, and day of birth</li>
                    <li>gender code (M or F)</li>
                </ul>
                <p>Within a try/catch block:</p>
                <ul>
                    <li>Creates a new DriversLicense object</li>
                    <li>Uses the utility classes to and the five setter methods to fill the object with data</li>
                    <li>Uses the two formatter objects to print the driver's license numbers for Florida and Wisconsin</li>
                </ul>
                <p>If an exception is thrown, print the exception message and exit the program.</p>
            </td>
        </tr>
    </tbody>
</table>
<p>&nbsp;</p>
<p>Only the Main class should perform input or output. Do not create Scanners or use System.out anywhere but in Main.</p>